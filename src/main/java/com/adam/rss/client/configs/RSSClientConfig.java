package com.adam.rss.client.configs;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@lombok.Value
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public record RSSConfig(@org.springframework.beans.factory.annotation.Value("${app.feeds.feed}") List<RSSFeed> feeds) {

    @Data
    @Setter
    @Getter
    @AllArgsConstructor
    class RSSFeed{
        String url;
        String name;
    }
}
