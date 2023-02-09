package com.varfolomeev.movierating.model;

import lombok.Getter;

@Getter
public enum OperationType {
    EVENT_OPERATION_ADD("ADD"),
    EVENT_OPERATION_REMOVE("REMOVE"),
    EVENT_OPERATION_UPDATE("UPDATE");

    private final String type;

    OperationType(String name) {
        this.type = name;
    }
}
