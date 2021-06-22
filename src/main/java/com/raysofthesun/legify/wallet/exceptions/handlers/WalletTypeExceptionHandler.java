package com.raysofthesun.legify.wallet.exceptions.handlers;

import com.raysofthesun.legify.exceptions.models.ExceptionResponse;
import com.raysofthesun.legify.wallet.exceptions.types.VaultIsEmptyException;
import com.raysofthesun.legify.wallet.exceptions.types.WalletNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WalletTypeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {WalletNotFoundException.class})
	ResponseEntity<Object> notFoundWalletExceptionHandler(WalletNotFoundException exception,
	                                                      ServletWebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
				exception.getErrorConfig().getCode());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {VaultIsEmptyException.class})
	ResponseEntity<Object> vaultEmptyExceptionHandler(Exception exception, ServletWebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(), "VLT-0");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
