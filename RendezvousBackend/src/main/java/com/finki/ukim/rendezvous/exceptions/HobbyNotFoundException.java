package com.finki.ukim.rendezvous.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HobbyNotFoundException extends RuntimeException{
    public HobbyNotFoundException(Long id) {
        super(String.format("hobby with id: %d is not found", id));
    }
}
