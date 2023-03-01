package com.adam.rss.client.services;

import com.adam.rss.client.configs.RSSFeedsConfig;
import com.adam.rss.client.exceptions.FeedClientException;
import com.adam.rss.client.models.RSSFeed;
import com.adam.rss.client.models.RSSFeedItem;
import com.adam.rss.client.util.RSSFeedUtils;
import com.rometools.rome.feed.synd.SyndFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@EnableAsync
@EnableScheduling
public class RSSFeedReader implements FeedReader {
    private final RSSFeedsConfig rssFeedsConfig;
    private final FeedReader rssFeedReader;
    private final FeedTicker rssFeedTicker;

    @Override
    public void read() {
        try {
            rssFeedsConfig.getRssFeedConfigs()
                    .parallelStream()
                    .map(RSSFeedUtils::buildSyndFeed)
                    .map(this::readFeed)
                    .forEach(rssFeedTicker::writeFeedsToTicker);
        } catch (Exception ex) {
            throw new FeedClientException(ex);
        }
    }

    private RSSFeed readFeed(SyndFeed feed) {
        return RSSFeed
                .builder()
                .rssFeedItemList(
                        Optional
                                .of(feed
                                        .getEntries()
                                        .parallelStream())
                                .orElseThrow()
                                .map(r -> RSSFeedItem
                                        .builder()
                                        .title(r.getTitle())
                                        .description(r.getDescription().getValue())
                                        .pubDate(r.getPublishedDate())
                                        .build())
                                .collect(Collectors.toList()))
                .build();
    }
}
