package com.finki.ukim.rendezvous.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MusicGenreNotFoundException extends RuntimeException{
    public MusicGenreNotFoundException(Long id) {
        super(String.format("music with id: %d is not found", id));
    }
}
