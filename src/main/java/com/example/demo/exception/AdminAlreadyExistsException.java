package com.example.demo.exception;

public class AdminAlreadyExistsException extends RuntimeException{
	public AdminAlreadyExistsException(String message) {
        super(message);
    }
}
