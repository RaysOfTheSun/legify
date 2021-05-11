package com.raysofthesun.legify.wallet.models;

import com.raysofthesun.legify.wallet.constants.WalletType;

public class CryptoWallet extends Wallet {

	public CryptoWallet() {
		super();
		this.type = WalletType.CRYPTO.toString();
	}
}
