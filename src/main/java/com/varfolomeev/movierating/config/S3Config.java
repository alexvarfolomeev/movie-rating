package com.varfolomeev.movierating.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class S3Config {
    private final S3Properties properties;

    @Bean
    public AmazonS3Client amazonS3Client() {
        var credentials = new BasicAWSCredentials(
                properties.getLogin(),
                properties.getPassword()
        );
        var clientConfig = new ClientConfiguration();
        clientConfig.setMaxConnections(properties.getMaxConnections());
        clientConfig.setRequestTimeout(properties.getRequestTimeout());
        clientConfig.setClientExecutionTimeout(properties.getClientExecutionTimeout());
        clientConfig.setConnectionTTL(properties.getConnectionTTL());


        return (AmazonS3Client) AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AF_SOUTH_1)
                .withClientConfiguration(clientConfig)
                .build();
    }
}
