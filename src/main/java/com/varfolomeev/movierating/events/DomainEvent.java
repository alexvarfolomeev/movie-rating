package com.varfolomeev.movierating.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public abstract class DomainEvent {
    protected LocalDate occuredOn;
}
