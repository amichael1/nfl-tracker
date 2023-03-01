package com.adam.rss.client.configs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Value
@Getter
@Setter
@Builder
public class NFLWebClientConfig {
    WebClient webClient;
    String path;
    Map<String, String> queryParams;
}
