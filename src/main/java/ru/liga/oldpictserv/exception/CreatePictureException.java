package ru.liga.oldpictserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CreatePictureException extends ResponseStatusException {
    public CreatePictureException() {
        super(HttpStatus.NOT_FOUND, "Can't create picture!");
    }
}
