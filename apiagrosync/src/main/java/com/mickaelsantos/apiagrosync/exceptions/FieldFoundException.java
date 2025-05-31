package com.mickaelsantos.apiagrosync.exceptions;

public class FieldFoundException extends RuntimeException{
    public FieldFoundException() {
        super("Field already exists with the same name in the farm.");
    }
}
