package ru.liga.oldpictserv.exception;

public class ParseTextException extends RuntimeException {
    public ParseTextException() {
        super("Can't parse text!");
    }
}

