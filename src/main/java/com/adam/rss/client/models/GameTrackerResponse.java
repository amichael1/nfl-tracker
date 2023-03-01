package com.adam.rss.client.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GameTrackerResponse {
    String id;
    @JsonAlias("sport_key")
    String sportKey;
    @JsonAlias("sport_title")
    String sportTitle;
    @JsonAlias("commence_time")
    Date commenceTime;
    @JsonAlias("home_team")
    String homeTeam;
    @JsonAlias("away_team")
    String awayTeam;
    List<Bookmaker> bookmakers;
    List<Score> scores;
}
