package com.varfolomeev.movierating.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Utils {
    public static String generateFileGUID(){
        return UUID.randomUUID().toString();
    }
}
