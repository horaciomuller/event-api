package dev.java10x.EnvetClean.infrastructure.exception;

public class DuplicateEventException extends RuntimeException{

    public DuplicateEventException(String message) {
        super(message);
    }

}
