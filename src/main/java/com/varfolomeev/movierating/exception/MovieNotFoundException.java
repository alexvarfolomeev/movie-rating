package com.varfolomeev.movierating.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieNotFoundException extends RuntimeException{
    private String message;
}
