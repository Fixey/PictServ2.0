package ru.liga.oldpictserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FormatTextException extends ResponseStatusException {
    public FormatTextException() {
        super(HttpStatus.NOT_FOUND, "Text has to contain hyphen or several words!");
    }
}
