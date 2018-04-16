package com.bloomon.exception;


public class StorageCapacityException extends Exception {

	private static final long serialVersionUID = 1L;

	public StorageCapacityException(String message) {
        super(message);
    }
	
	public StorageCapacityException() {
        super();
    }

}