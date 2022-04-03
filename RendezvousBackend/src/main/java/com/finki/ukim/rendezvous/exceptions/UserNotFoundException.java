package com.finki.ukim.rendezvous.exceptions
        ;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super(String.format("User with id: %d is not found", id));
    }
}

