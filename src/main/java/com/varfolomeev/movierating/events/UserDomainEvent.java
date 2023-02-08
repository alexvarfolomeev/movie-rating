package com.varfolomeev.movierating.events;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserDomainEvent extends DomainEvent {
    private final long userId;

    public UserDomainEvent(LocalDate occuredOn, long userId) {
        super(occuredOn);
        this.userId = userId;
    }
}
