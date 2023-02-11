package com.varfolomeev.movierating.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenreNotFoundException extends Exception {
    private String message;
}
