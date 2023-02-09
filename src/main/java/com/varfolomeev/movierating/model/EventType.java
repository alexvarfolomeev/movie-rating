package com.varfolomeev.movierating.model;

import lombok.Getter;

@Getter
public enum EventType {
    LIKE_EVENT("LIKE"),
    FRIEND_EVENT("FRIEND"),
    REVIEW_EVENT("REVIEW");

    private final String type;

    EventType(String name) {
        this.type = name;
    }
}
