package com.raysofthesun.legify.exceptions.handlers;

import com.raysofthesun.legify.exceptions.models.ExceptionResponse;
import com.raysofthesun.legify.exceptions.wallet.WalletNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LegifyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {WalletNotFoundException.class})
	protected ResponseEntity<Object> handleNotFoundExceptions(RuntimeException runtimeException,
	                                                          WebRequest webRequest) {
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(runtimeException.getMessage(), "W001");

		return handleExceptionInternal(runtimeException, exceptionResponse,
				new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}
}
