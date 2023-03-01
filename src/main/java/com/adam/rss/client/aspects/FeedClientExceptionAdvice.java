package com.adam.rss.client.aspects;

import com.adam.rss.client.exceptions.FeedClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

public class FeedClientExceptionAdvice implements ThrowsAdvice {

    private static final Logger log = LoggerFactory.getLogger(FeedClientExceptionAdvice.class);

    public void afterThrowing(FeedClientException ex) throws Throwable {
        log.error(ex.getMessage());
    }
}