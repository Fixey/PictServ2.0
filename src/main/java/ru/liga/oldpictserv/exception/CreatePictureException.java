package ru.liga.oldpictserv.exception;

public class CreatePictureException extends RuntimeException {
    public CreatePictureException() {
        super("Can't create picture!");
    }
}
