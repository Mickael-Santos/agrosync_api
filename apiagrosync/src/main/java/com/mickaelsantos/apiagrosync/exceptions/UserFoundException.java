package com.mickaelsantos.apiagrosync.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Farm with this identification already exists");
    }
}
