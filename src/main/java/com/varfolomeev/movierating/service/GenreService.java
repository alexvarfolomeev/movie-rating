package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreService {

    private final JdbcTemplate jdbcTemplate;

    private final GenreRepository genreRepository;

}
