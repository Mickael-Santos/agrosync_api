package com.mickaelsantos.apiagrosync.exceptions;

public class FarmNotFoundException extends RuntimeException {
    public FarmNotFoundException() {
        super("Farm not found");
    }
}
