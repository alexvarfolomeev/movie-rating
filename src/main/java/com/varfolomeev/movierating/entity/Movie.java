package com.varfolomeev.movierating.entity;

import com.varfolomeev.movierating.model.MpaaRating;
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
    private String country;
    private String director;
    private LocalDate releaseDate;
    private Integer duration;
    private String moviePosterKey;
    @Enumerated(EnumType.STRING)
    private MpaaRating mpaa;
    private Integer age;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_genre",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Likes>likes;
}
