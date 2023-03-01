package com.adam.rss.client.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "adam.rss.client")
public class RSSClientConfig {
    Map<String, String> feeds;

    @Bean
    public RSSFeedsConfig rssFeedConfig() {
        return RSSFeedsConfig
                .builder()
                .rssFeedConfigs(
                        feeds.keySet()
                                .parallelStream()
                                .map((k) -> {
                                    try {
                                        return RSSFeedConfig
                                                .builder()
                                                .name(k)
                                                .url(new URL(feeds.get(k)))
                                                .build();
                                    } catch (MalformedURLException e) {
                                        throw new RuntimeException(e);
                                    }
                                })
                                .collect(Collectors.toList()))
                .build();
    }
}