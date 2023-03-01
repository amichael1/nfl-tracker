package com.adam.rss.client.exceptions;

public class FeedClientException extends RuntimeException {
    public FeedClientException(Exception ex) {
        super(ex);
    }
}
