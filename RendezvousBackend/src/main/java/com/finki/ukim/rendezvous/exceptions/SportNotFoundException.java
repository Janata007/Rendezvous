package com.finki.ukim.rendezvous.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SportNotFoundException extends RuntimeException{
    public SportNotFoundException(Long id) {
        super(String.format("sport with id: %d is not found", id));
    }
}
