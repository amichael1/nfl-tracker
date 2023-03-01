package com.adam.rss.client.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Date;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class RSSFeedItem {

    String title;
    String description;
    Date pubDate;
}
