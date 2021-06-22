package com.raysofthesun.legify.exceptions.models;

import lombok.Getter;

public class LegifyConfigurableException extends RuntimeException {

	@Getter
	final private ErrorConfig errorConfig;

	public LegifyConfigurableException(ErrorConfig errorConfig, String errorMessage) {
		super(errorMessage);
		this.errorConfig = errorConfig;
	}
}
