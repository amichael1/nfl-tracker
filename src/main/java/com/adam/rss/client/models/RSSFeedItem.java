package com.adam.scrapper.models;

import lombok.*;

@Value
@ToString
public record RssFeedItem(String title, String description, String pubDate) {


}
