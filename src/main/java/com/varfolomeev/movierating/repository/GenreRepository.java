package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreByName(String name);
}
