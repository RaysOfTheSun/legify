package com.raysofthesun.legify.wallet.models;

import com.raysofthesun.legify.wallet.constants.WalletType;

public class FiatWallet extends Wallet {
	public FiatWallet() {
		super();
		this.type = WalletType.FIAT.toString();
	}
}
