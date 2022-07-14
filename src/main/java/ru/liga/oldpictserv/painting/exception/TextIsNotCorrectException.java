package ru.liga.oldpictserv.painting.exception;

public class TextIsNotCorrectException extends RuntimeException {
    public TextIsNotCorrectException() {
        super("Input is not correct!");
    }
}