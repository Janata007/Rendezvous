package com.finki.ukim.rendezvous.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(Long id) {
        super(String.format("location with id: %d is not found", id));
    }
}
