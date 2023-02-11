package com.varfolomeev.movierating.controller;

import com.varfolomeev.movierating.entity.Genre;
import com.varfolomeev.movierating.exception.GenreNotFoundException;
import com.varfolomeev.movierating.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/genre")
public class GenreController {

    private final GenreRepository genreRepository;

    @GetMapping("/get-all")
    public Collection<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Genre getGenre(@PathVariable Long id) throws GenreNotFoundException {
        return genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found")
                );
    }
}
