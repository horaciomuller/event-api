package dev.java10x.EventClean.infrastructure.exception;

public class DuplicateEventException extends RuntimeException{

    public DuplicateEventException(String message) {
        super(message);
    }

}
