package com.gcit.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

/*
as its name suggests It's for handle the exceptions
 */
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
