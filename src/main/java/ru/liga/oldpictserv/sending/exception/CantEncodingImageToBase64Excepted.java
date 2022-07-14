package ru.liga.oldpictserv.sending.exception;

public class CantEncodingImageToBase64Excepted extends RuntimeException {
    public CantEncodingImageToBase64Excepted() {
        super("Can't encoding Image to Base64! May be image is not exist.");
    }
}
