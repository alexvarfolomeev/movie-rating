package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
    @Override
    Optional<Movie> findById(Long aLong);
}
