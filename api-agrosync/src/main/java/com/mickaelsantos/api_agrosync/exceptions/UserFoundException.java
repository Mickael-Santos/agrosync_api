package com.mickaelsantos.api_agrosync.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Farm with this identification already exists");
    }
}
