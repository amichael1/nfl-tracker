package com.adam.rss.client.services;

import com.adam.rss.client.configs.RSSFeedConfig;
import com.adam.rss.client.configs.RSSFeedsConfig;
import com.adam.rss.client.exceptions.FeedClientException;
import com.adam.rss.client.models.RSSFeed;
import com.adam.rss.client.models.RSSFeedItem;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@EnableAsync
@EnableScheduling
public class RSSFeedReaderService implements FeedReader {
    private final RSSFeedsConfig rssFeedsConfig;
    private final FeedTicker rssFeedTicker;

    @Override
    public void read() {
        try {
            rssFeedsConfig.getRssFeedConfigs()
                    .parallelStream()
                    .map(this::getRSSFeedData)
                    .map(this::readFeed)
                    .forEach(rssFeedTicker::writeFeedsToTicker);
        } catch (Exception ex) {
            throw new FeedClientException(ex);
        }
    }

    private RSSFeed readFeed(SyndFeed feed) {
        return RSSFeed.builder()
                .rssFeedItemList(Optional.of(
                                feed.getEntries()
                                        .parallelStream())
                        .orElseThrow()
                        .map(r ->
                                RSSFeedItem.builder()
                                        .title(r.getTitle())
                                        .description(r.getDescription().getValue())
                                        .pubDate(r.getPublishedDate())
                                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private SyndFeed getRSSFeedData(RSSFeedConfig feed) {
        try {
            return (new SyndFeedInput()).build(new XmlReader(feed.getUrl()));
        } catch (FeedException | IOException e) {
            throw new FeedClientException(e);
        }
    }
}
