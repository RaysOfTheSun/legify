package com.raysofthesun.legify.wallet.constants;

import com.raysofthesun.legify.wallet.models.CryptoWallet;
import com.raysofthesun.legify.wallet.models.FiatWallet;
import com.raysofthesun.legify.wallet.models.Wallet;

import java.util.function.Supplier;

public enum WalletFactory {
	FIAT(FiatWallet::new),
	CRYPTO(CryptoWallet::new);

	public final Supplier<Wallet> walletSupplier;
	private WalletFactory(Supplier<Wallet> walletSupplier) {
		this.walletSupplier = walletSupplier;
	}
}
