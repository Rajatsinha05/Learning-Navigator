package com.Navigator.Exceptions;
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
