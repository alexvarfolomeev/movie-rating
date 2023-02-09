package com.varfolomeev.movierating.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
@ToString
@JsonIgnoreProperties({"user", "movie"})
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}

