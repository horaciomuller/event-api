package dev.java10x.EnvetClean.infrastructure.exception;

public class NotFoundEventException extends RuntimeException {
    public NotFoundEventException(String message) {
        super(message);
    }
}

