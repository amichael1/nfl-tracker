package com.adam.rss.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.adam")
public class RSSFeedService {

    public static void main(String[] args) {
        SpringApplication.run(RSSFeedService.class, args);
    }

}
