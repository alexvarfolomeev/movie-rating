package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.Likes;
import com.varfolomeev.movierating.events.UserLikedMovie;
import com.varfolomeev.movierating.events.UserUnlikedMovie;
import com.varfolomeev.movierating.exception.MovieNotFoundException;
import com.varfolomeev.movierating.exception.UserNotFoundException;
import com.varfolomeev.movierating.repository.LikeRepository;
import com.varfolomeev.movierating.repository.MovieRepository;
import com.varfolomeev.movierating.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;

@Service
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void doLike(Long userId, Long movieId) {
        isUserExists(userId);
        isFilmExists(movieId);

        likeRepository.save(Likes.builder()
                .user(userRepository.findById(userId).orElseThrow())
                .createdAt(LocalDate.now())
                .movie(movieRepository.findById(movieId).orElseThrow())
                .build());
        eventPublisher.publishEvent(new UserLikedMovie(LocalDate.now(), userId, movieId));
    }

    @Transactional
    public void doUnlike(long userId, long movieId) {
        isUserExists(userId);
        isFilmExists(movieId);
        var like = likeRepository.findLikesByUserIdAndMovieId(userId, movieId);
        like.ifPresent(l -> {
            likeRepository.delete(l);
            eventPublisher.publishEvent(new UserUnlikedMovie(LocalDate.now(),
                    userId, movieId));
        });
    }

    public Collection<Likes>findAllMovieLikes(Long movieId){
        return likeRepository.findAllByMovieMovieId(movieId);
    }

    private void isUserExists(long userId) {
        userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(String.valueOf(userId)));
    }

    private void isFilmExists(long filmId) {
        movieRepository.findById(filmId).orElseThrow(() ->
                new MovieNotFoundException(String.valueOf(filmId)));
    }

}
