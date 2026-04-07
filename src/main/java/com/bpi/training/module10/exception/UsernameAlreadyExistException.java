package com.bpi.training.module10.exception;

public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException() {
        super("Username already exists.");
    }
}
