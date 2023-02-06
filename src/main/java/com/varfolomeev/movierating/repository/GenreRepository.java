package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreByName(String name);
}
