package com.adam.rss.client.tasks;

import com.adam.rss.client.services.GameTracker;
import com.adam.rss.client.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@EnableAsync
@EnableScheduling
public class GameUpdateTask {
    private final GameTracker oddsApiService;

    @Scheduled(fixedRate = Constants.GAME_UPDATE_TASK_TIMER)
    public void updateGameInfo() {
        oddsApiService.getGameUpdates();
    }
}
