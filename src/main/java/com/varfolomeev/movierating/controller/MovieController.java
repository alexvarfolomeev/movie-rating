package com.varfolomeev.movierating.controller;

import com.varfolomeev.movierating.exception.MovieException;
import com.varfolomeev.movierating.model.Movie;
import com.varfolomeev.movierating.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<?>addMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return ResponseEntity.ok(movie.getName() + " saved");
    }

    @GetMapping("/get-movies/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieService.findMovieById(id).orElseThrow(
                () -> new MovieException(
                        String.format("Movie with id - %d - is not found.", id)
                ));
    }

    @GetMapping("/get-movies/all")
    public List<Movie> getAllMovies(){
        return movieService.findAllMovies();
    }

    @PostMapping("/add-all-movies")
    public Set<Movie> addAllMovies(@RequestBody Set<Movie> movies){
        return movieService.saveAllMovies(movies);
    }
}
