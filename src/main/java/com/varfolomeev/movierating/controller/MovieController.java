package com.varfolomeev.movierating.controller;

import com.varfolomeev.movierating.entity.Movie;
import com.varfolomeev.movierating.exception.MovieNotFoundException;
import com.varfolomeev.movierating.service.LikeService;
import com.varfolomeev.movierating.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;
    private final LikeService likeService;

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return ResponseEntity.ok(movie.getName() + " saved");
    }

    @GetMapping("/get-movies/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.findMovieById(id).orElseThrow(
                () -> new MovieNotFoundException(
                        String.format("Movie with id - %d - is not found.", id)
                ));
    }

    @PutMapping("/{movieId}/like/{userId}")
    public ResponseEntity<?> addLike(@PathVariable Long movieId, @PathVariable Long userId) {
        likeService.doLike(userId, movieId);
        return ResponseEntity.ok("You liked the movie - " + movieId);
    }

    @DeleteMapping("/{movieId}/unlike/{userId}")
    public ResponseEntity<?> removeLike(@PathVariable Long movieId, @PathVariable Long userId) {
        likeService.doUnlike(userId, movieId);
        return ResponseEntity.ok("You unliked the movie - " + movieId);
    }

    @GetMapping("/likes/{id}")
    public ResponseEntity<?> getAllMovieLikes(@PathVariable Long id) { // TODO: 09.02.2023 ПРОТЕСТИРОВАТЬ МЕТОД
        return ResponseEntity.status(HttpStatus.OK)
                .body((long) likeService.findAllMovieLikes(id).size());
    }

    @GetMapping("/get-movies/all")
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }

    @PostMapping("/add-all-movies")
    public Set<Movie> addAllMovies(@RequestBody Set<Movie> movies) {
        return movieService.saveAllMovies(movies);
    }
}
