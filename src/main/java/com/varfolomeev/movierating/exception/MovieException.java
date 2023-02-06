package com.varfolomeev.movierating.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieException extends RuntimeException{
    private String message;
}
