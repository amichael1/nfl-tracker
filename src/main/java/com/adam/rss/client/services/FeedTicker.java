package com.adam.rss.client.services;

import com.adam.rss.client.models.RSSFeed;
import org.springframework.stereotype.Component;

@Component
public interface FeedTicker {
    void writeFeedsToTicker(RSSFeed rssFeed);
}
