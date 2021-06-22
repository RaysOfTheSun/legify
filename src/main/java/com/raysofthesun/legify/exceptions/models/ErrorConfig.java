package com.raysofthesun.legify.exceptions.models;

import lombok.Data;

@Data
final public class ErrorConfig {
	private String code;
	private String template;
}
