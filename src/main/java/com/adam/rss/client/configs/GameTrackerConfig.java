package com.adam.rss.client.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "adam.odds.client")
public class GameTrackerConfig {
    private static final String REQUEST_URI = "uri";

    private String baseUrl;

    private Map<String, String> odds;

    private Map<String, String> scores;


    @Bean
    public List<GameTrackerWebClientConfig> nflWebClients() {
        return Stream.of(odds, scores)
                .map(r -> GameTrackerWebClientConfig.builder()
                        .path(r.remove(REQUEST_URI))
                        .queryParams(r)
                        .webClient(WebClient.builder()
                                .baseUrl(baseUrl)
                                .build())
                        .build())
                .collect(Collectors.toList());
    }

}
