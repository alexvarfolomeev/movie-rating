package com.varfolomeev.movierating.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MpaaRating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private final String name;

    MpaaRating(String name) {
        this.name = name;
    }

    public int getId() {
        return ordinal() + 1;
    }

    public String getName() {
        return name;
    }

    @JsonCreator
    public static MpaaRating forObject(@JsonProperty("id") int id) {
        return MpaaRating.values()[id - 1];
    }
}
