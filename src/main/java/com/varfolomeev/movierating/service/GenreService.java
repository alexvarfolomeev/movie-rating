package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.Genre;
import com.varfolomeev.movierating.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public Optional<Genre> findGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public Collection<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

}