package ru.liga.oldpictserv.painting.exception;

public class CreatePictureException extends RuntimeException {
    public CreatePictureException() {
        super("Can't create picture!");
    }
}
