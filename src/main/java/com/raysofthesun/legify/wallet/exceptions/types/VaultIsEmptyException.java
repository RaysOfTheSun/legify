package com.raysofthesun.legify.wallet.exceptions.types;

public class VaultIsEmptyException extends RuntimeException {
	public VaultIsEmptyException() {
		super("No wallets found");
	}
}
