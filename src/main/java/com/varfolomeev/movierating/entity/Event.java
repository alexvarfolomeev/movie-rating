package com.varfolomeev.movierating.entity;

import com.varfolomeev.movierating.model.EventType;
import com.varfolomeev.movierating.model.OperationType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long eventId;

    private long userId;

    private long entityId;

    private LocalDate occurredOn;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Enumerated(EnumType.STRING)
    private OperationType operation;
}
