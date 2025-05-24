package com.mickaelsantos.api_agrosync.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(String message) {
        super("Farm with this identification already exists");
    }
}
