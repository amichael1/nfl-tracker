package com.adam.rss.client.services;

import org.springframework.stereotype.Component;

@Component
public interface FeedReader {
    void read();
}
