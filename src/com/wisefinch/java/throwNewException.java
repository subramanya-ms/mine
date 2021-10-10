package com.wisefinch.java;

import org.openqa.selenium.WebElement;

public class throwNewException extends Exception {

	String capturedError;
	private static final long serialVersionUID = 1L;

	public throwNewException(String fieldName, String errorText) {
		// TODO Auto-generated constructor stub
		this.capturedError = "Element Name : "+fieldName + ". Error Text : "
				 + errorText;
		System.out.println("############ Error : "+capturedError);
	}

	public String getErrorMessage() {
		return capturedError;
	}
}
