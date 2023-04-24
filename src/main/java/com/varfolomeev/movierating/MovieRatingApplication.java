package com.varfolomeev.movierating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MovieRatingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieRatingApplication.class, args);
    }
}
