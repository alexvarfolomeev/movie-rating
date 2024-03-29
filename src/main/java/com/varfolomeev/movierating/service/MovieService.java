package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.Movie;
import com.varfolomeev.movierating.exception.MovieNotFoundException;
import com.varfolomeev.movierating.repository.GenreRepository;
import com.varfolomeev.movierating.repository.LikeRepository;
import com.varfolomeev.movierating.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public Movie saveMovie(Movie movie) {
        var movieFromDb = movieRepository.findMovieByName(movie.getName());
        if (movieFromDb.isPresent()){
            return movieFromDb.get();
        }
        var genreSet = movie.getGenres().stream()
                .map(g -> genreRepository.findGenreByName(g.getName()))
                .collect(Collectors.toSet());
        movie.setGenres(genreSet);
        movieRepository.save(movie);
        return movie;
    }

    @Transactional
    public Set<Movie> saveAllMovies(Set<Movie> movies) {
        return movies.stream()
                .map(this::saveMovie)
                .collect(Collectors.toSet());
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findMovieByName(String name){
        return movieRepository.findMovieByName(name);
    }

    public List<Movie> findLikedMovies(Long userId) {
        return likeRepository.findAllLikedMovies(userId);
    }
}
