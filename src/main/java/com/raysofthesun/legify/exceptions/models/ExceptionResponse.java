package com.raysofthesun.legify.exceptions.models;

import lombok.Getter;

public class ExceptionResponse {

	@Getter
	final private String errorCode;

	@Getter
	final private String errorMessage;

	public ExceptionResponse(String errorMessage, String errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
