package com.example.OrderFood.OrderFoodProject.exception;

public class DuplicateRecordException extends RuntimeException{
	public DuplicateRecordException(String message) {
		super(message);
	}
}