package com.varfolomeev.movierating.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "movie")
@EqualsAndHashCode(of = "description")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    private LocalDate releaseDate;
    private Integer duration;
    private String mpaa;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_genre",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Genre> genres = new HashSet<>();
}
