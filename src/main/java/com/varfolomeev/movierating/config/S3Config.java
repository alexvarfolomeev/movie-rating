package com.varfolomeev.movierating.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.S3ClientOptions;
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

        var client = (AmazonS3Client) AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(properties.getEndpoint(), Regions.DEFAULT_REGION.getName()))
                .withClientConfiguration(clientConfig)
                .withPathStyleAccessEnabled(true)
                .build();
        return client;
    }
}
