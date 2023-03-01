package com.adam.rss.client.configs;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.net.URL;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class RSSFeedConfig {
    URL url;
    String name;
}