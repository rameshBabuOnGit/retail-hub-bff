package com.retailhub.retailhubbff.exception;

public class InvalidCartDetailsException extends RuntimeException{
    public InvalidCartDetailsException(String message) {
        super(message);
    }
}
