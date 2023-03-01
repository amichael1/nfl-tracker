package com.adam.rss.client.tasks;

import com.adam.rss.client.configs.RSSFeedsConfig;
import com.adam.rss.client.services.FeedReader;
import com.adam.rss.client.services.FeedTicker;
import com.adam.rss.client.util.RSSFeedUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RSSFeedClientService {
    private static final Logger log = LoggerFactory.getLogger(RSSFeedClientService.class);
    private RSSFeedsConfig rssFeedsConfig;
    private FeedReader rssFeedReader;

    private FeedTicker rssFeedTicker;

    @Scheduled(fixedRate = 30000)
    public void updateRSSFeed(){
        rssFeedsConfig.getRssFeedConfigs()
                .parallelStream()
                .map(RSSFeedUtils::buildSyndFeed)
                .map(rssFeedReader::read)
                .forEach(rssFeedTicker::writeFeedsToTicker);
    }




}
