package com.adam.rss.client.util;

import com.adam.rss.client.configs.GameTrackerWebClientConfig;
import org.springframework.web.util.UriBuilder;

import java.net.URI;


public class WebClientBuilderUtil {

    public static URI nflWebClientUri(UriBuilder uriBuilder, GameTrackerWebClientConfig config) {
        uriBuilder.path(config.getPath());
        config.getQueryParams()
                .entrySet()
                .parallelStream()
                .forEach(e -> uriBuilder.queryParam(e.getKey(), e.getValue()));

        return uriBuilder.build();
    }
}
