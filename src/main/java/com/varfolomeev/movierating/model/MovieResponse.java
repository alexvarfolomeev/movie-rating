package com.varfolomeev.movierating.model;

import com.varfolomeev.movierating.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class MovieResponse {
    private final Long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;
    private String mpaa;
    private Set<Genre> genres;
}
