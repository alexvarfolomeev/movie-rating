package com.varfolomeev.movierating.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@ToString
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
    private Long user;
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}

