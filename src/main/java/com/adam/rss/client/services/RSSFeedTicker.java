package com.adam.rss.client.services;

import com.adam.rss.client.models.RSSFeed;
import org.springframework.stereotype.Component;

@Component
public class RSSFeedTicker implements FeedTicker {

    @Override
    public void writeFeedsToTicker(RSSFeed rssFeed) {
        rssFeed.getRssFeedItemList()
                .parallelStream()
                .forEach(System.out::println);
    }
}
