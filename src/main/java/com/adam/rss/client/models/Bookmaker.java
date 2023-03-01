package com.adam.rss.client.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Bookmaker {
    String key;
    String title;
    String lastUpdate;
    List<Market> markets;
}
