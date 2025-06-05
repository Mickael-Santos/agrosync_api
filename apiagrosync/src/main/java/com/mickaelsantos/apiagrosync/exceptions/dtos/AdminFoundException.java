package com.mickaelsantos.apiagrosync.exceptions.dtos;

public class AdminFoundException extends RuntimeException {
    public AdminFoundException() {
        super("Admin with this username or email already exists");
    }
}
