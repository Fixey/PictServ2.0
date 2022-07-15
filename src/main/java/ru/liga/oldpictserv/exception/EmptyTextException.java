package ru.liga.oldpictserv.exception;

public class EmptyTextException extends RuntimeException {
    public EmptyTextException() {
        super("Text is empty!");
    }
}
