package ru.liga.oldpictserv.parsetext.exception;

public class CantParseTextException extends RuntimeException {
    public CantParseTextException() {
        super("Can't parse text!");
    }
}

