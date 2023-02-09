package com.varfolomeev.movierating.events.listener;

import com.varfolomeev.movierating.entity.Event;
import com.varfolomeev.movierating.events.UserLikedMovie;
import com.varfolomeev.movierating.events.UserUnlikedMovie;
import com.varfolomeev.movierating.model.EventType;
import com.varfolomeev.movierating.model.OperationType;
import com.varfolomeev.movierating.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.varfolomeev.movierating.model.EventType.LIKE_EVENT;
import static com.varfolomeev.movierating.model.OperationType.EVENT_OPERATION_ADD;
import static com.varfolomeev.movierating.model.OperationType.EVENT_OPERATION_REMOVE;

@Component
@AllArgsConstructor
public class LikeEventListener {

    private final EventRepository eventRepository;

    @EventListener(UserLikedMovie.class)
    public void onUserLikedFilm(UserLikedMovie event) {
        eventRepository.save(new Event(
                null,
                event.getUserId(),
                event.getMovieId(),
                event.getOccuredOn(),
                LIKE_EVENT,
                EVENT_OPERATION_ADD
        ));
    }

    @EventListener(UserUnlikedMovie.class)
    public void onUserRevokedLikeOfFilm(UserUnlikedMovie event) {
        eventRepository.save(new Event(
                null,
                event.getUserId(),
                event.getMovieId(),
                event.getOccuredOn(),
                LIKE_EVENT,
                EVENT_OPERATION_REMOVE
        ));
    }

}
