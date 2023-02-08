package com.varfolomeev.movierating.events;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserLikedMovie extends UserDomainEvent {
    private final Long movieId;

    public UserLikedMovie(LocalDate occuredOn, long userId, Long movieId) {
        super(occuredOn, userId);
        this.movieId = movieId;
    }
}
