package com.adam.rss.client.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class RSSFeeds {
    List<RSSFeed> rssFeedList;
}
