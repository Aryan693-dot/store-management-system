package com.example.demo.exception;

public class NoSuchStoreAvailable extends RuntimeException{
	public NoSuchStoreAvailable(String msg) {
		super(msg);
	}
}
