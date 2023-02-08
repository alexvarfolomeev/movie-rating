package com.varfolomeev.movierating.events;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserUnlikedMovie extends UserDomainEvent {
    private final Long movieId;

    public UserUnlikedMovie(LocalDate occuredOn, long userId, Long movieId) {
        super(occuredOn, userId);
        this.movieId = movieId;
    }
}
