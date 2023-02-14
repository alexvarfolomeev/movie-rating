package com.varfolomeev.movierating.config;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class S3Properties {
    private final String accessKey = "AKIARU2ZFDTZ2RD5X7VV";
    private final String secretKey = "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";
    private final String bucketName= "movie-rate-posters";
    private final Integer maxConnections = 500;
    private final Integer requestTimeout = 180000;
    private final Integer clientExecutionTimeout = 180000;
    private final Long connectionTTL = 180000L;
}
