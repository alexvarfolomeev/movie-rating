package com.varfolomeev.movierating.config;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class S3Properties {
    private final String endpoint = "http://localhost:9610";
    private final String login = "admin";
    private final String password = "admin";
    private final String bucketName= "movie-rate-pics";
    private final Integer maxConnections = 500;
    private final Integer requestTimeout = 180000;
    private final Integer clientExecutionTimeout = 180000;
    private final Long connectionTTL = 180000L;
}
