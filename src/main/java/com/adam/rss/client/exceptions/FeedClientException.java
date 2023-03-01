package com.adam.rss.client.exceptions;

public class RSSFeedClientException extends RuntimeException{
    public RSSFeedClientException(Exception ex) {
        super(ex);
    }
}
