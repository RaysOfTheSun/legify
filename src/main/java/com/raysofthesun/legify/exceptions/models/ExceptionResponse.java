package com.raysofthesun.legify.exceptions.models;

import lombok.Getter;

public final class ExceptionResponse {
	@Getter
	final private String message;

	@Getter
	final private String errorCode;

	public ExceptionResponse(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
}
