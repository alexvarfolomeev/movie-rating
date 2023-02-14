package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    @Query("select l from Likes l where l.user.id = :userId and l.movie.movieId = :movieId")
    Optional<Likes> findLikesByUserIdAndMovieId(@Param("userId") Long userId, @Param("movieId") Long movieId);

    Collection<Likes> findAllByMovieMovieId(Long id);

}
