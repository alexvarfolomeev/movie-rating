package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.Movie;
import com.varfolomeev.movierating.repository.GenreRepository;
import com.varfolomeev.movierating.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

//    @Transactional
//    public void saveMovie(MovieRequest movie){
//        Set<Genre> genreSet = movie.getGenres().stream()
//                .map(g -> genreRepository.findGenreByName(g.getName()))
//                .collect(Collectors.toSet());
//        var movieEntity = Movie.builder()
//                        .name(movie.getName())
//                        .description(movie.getDescription())
//                        .duration(movie.getDuration())
//                        .releaseDate(movie.getReleaseDate())
//                        .mpaa(movie.getMpaa())
//                        .genres(genreSet)
//                        .build();
//        movieRepository.save(movieEntity);
//    }

    @Transactional
    public Movie saveMovie(Movie movie) {
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


}
