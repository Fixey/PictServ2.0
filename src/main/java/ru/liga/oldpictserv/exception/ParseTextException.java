package ru.liga.oldpictserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ParseTextException extends ResponseStatusException {
    public ParseTextException() {
        super(HttpStatus.NOT_FOUND, "Can't parse text!");
    }
}

