package ru.liga.oldpictserv.exception;

public class FormatTextException extends RuntimeException {
    public FormatTextException() {
        super("Text has to contain hyphen or several words!");
    }
}
