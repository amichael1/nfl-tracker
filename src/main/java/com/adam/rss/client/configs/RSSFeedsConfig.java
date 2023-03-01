package com.adam.rss.client.configs;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class RSSFeedsConfig {
    List<RSSFeedConfig> rssFeedConfigs;
}
