package com.raysofthesun.legify.wallet.exceptions.types;

public class InvalidWalletTypeException extends RuntimeException {
	public InvalidWalletTypeException(String walletType) {
		super(String.format("Failed to create a wallet of type %s as %<s is not a valid wallet type.", walletType));
	}
}
