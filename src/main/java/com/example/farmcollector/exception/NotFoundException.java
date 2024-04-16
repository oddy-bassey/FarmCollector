package com.example.farmcollector.exception;

public class NotFoundException extends IllegalStateException{
    public NotFoundException(String s) {
        super(s);
    }
}
