package ru.liga.oldpictserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmptyTextException extends ResponseStatusException {
    public EmptyTextException() {
        super(HttpStatus.NOT_FOUND, "Text is empty!");
    }
}
