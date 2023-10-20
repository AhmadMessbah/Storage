package com.mftplus.storage.exception;

public class NoContentException extends Exception {
    private String message;

    public NoContentException() {
        message = "No Content Found";
    }

    public NoContentException(String message) {
        super(message);
        this.message = message;
    }


}
