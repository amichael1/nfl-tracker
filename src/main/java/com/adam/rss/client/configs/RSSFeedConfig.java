package com.adam.rss.client.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public record RSSFeed(String url, String name){

}