package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
    Optional<Event> findById(Long aLong);
}
