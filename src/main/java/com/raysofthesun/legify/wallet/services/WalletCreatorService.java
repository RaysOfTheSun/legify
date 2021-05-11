package com.raysofthesun.legify.wallet.services;

import com.raysofthesun.legify.wallet.constants.WalletFactory;
import com.raysofthesun.legify.wallet.constants.WalletType;
import com.raysofthesun.legify.wallet.exceptions.types.InvalidWalletTypeException;
import com.raysofthesun.legify.wallet.models.Wallet;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
final public class WalletCreatorService {
	private boolean isValidWalletType(String walletType) {
		return Arrays
				.stream(WalletType.values())
				.anyMatch((type) -> type.toString().equals(walletType));
	}

	public Wallet makeWalletFromMeta(Wallet wallet) {
		String walletTypeToCreate = wallet.getType().toUpperCase();

		if (!isValidWalletType(walletTypeToCreate)) {
			throw new InvalidWalletTypeException(walletTypeToCreate);
		}

		final Wallet createdWallet = WalletFactory
				.valueOf(walletTypeToCreate).walletSupplier.get();

		return createdWallet.clone(wallet);
	}
}
