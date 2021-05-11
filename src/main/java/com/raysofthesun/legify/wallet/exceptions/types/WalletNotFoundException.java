package com.raysofthesun.legify.wallet.exceptions.types;

public class WalletNotFoundException extends RuntimeException {
	public WalletNotFoundException(String walletId) {
		// TODO: place error messages in a JSON config file for easy modification
		super(String.format("The operation involving the wallet with the id of %s failed as it " +
				"does not exist.", walletId));
	}
}
