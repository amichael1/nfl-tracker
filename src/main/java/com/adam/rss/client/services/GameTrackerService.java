package com.adam.rss.client.services;

import com.adam.rss.client.configs.GameTrackerWebClientConfig;
import com.adam.rss.client.models.NFLResponse;
import com.adam.rss.client.util.WebClientBuilderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@EnableAsync
public class OddsApiService implements GameTracker {

    private final List<GameTrackerWebClientConfig> nflWebClients;

    public void getGameUpdates() {
        nflWebClients.stream()
                .map(r -> r.getWebClient()
                        .get()
                        .uri(uriBuilder -> WebClientBuilderUtil.nflWebClientUri(uriBuilder, r))
                        .retrieve()
                        .bodyToFlux(NFLResponse.class))
                .toList()
                .parallelStream()
                .forEach(r -> r.subscribe(System.out::println));

    }

}
