package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
    @Override
    Optional<Movie> findById(Long aLong);
    Optional<Movie> findMovieByName(String name);
}
