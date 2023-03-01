package com.adam.rss.client.services;

import com.adam.rss.client.models.RSSFeeds;

public interface FeedTickerWriter {
    void writeFeedsToTicker(RSSFeeds rssFeeds);
}
