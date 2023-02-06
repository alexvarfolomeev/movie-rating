package com.varfolomeev.movierating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class MovieRequest {
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;
    private String mpaa;
    private Set<Genre> genres;
}
