package com.raysofthesun.legify.wallet.services;

import com.raysofthesun.legify.wallet.constants.WalletType;
import com.raysofthesun.legify.wallet.models.FiatWallet;
import com.raysofthesun.legify.wallet.models.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WalletCreatorService")
public class WalletCreatorServiceTests {

	private final WalletCreatorService walletCreatorService;

	public WalletCreatorServiceTests() {
		this.walletCreatorService = new WalletCreatorService();
	}

	@Test
	@DisplayName("should create a wallet given that the supplied meta information provides a valid wallet type")
	public void createWalletWhenTypeIsValid() {
		Wallet createdWallet = this.walletCreatorService.makeWalletFromMeta(new FiatWallet());
		assertAll(
				() -> assertEquals(createdWallet.getType(), WalletType.FIAT.name()),
				() -> assertDoesNotThrow(() -> this.walletCreatorService.makeWalletFromMeta(new FiatWallet()))
		);
	}
}
