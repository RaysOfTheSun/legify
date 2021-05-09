package com.raysofthesun.legify.services.wallet;

import com.raysofthesun.legify.exceptions.wallet.WalletNotFoundException;
import com.raysofthesun.legify.models.wallet.Wallet;
import com.raysofthesun.legify.repositories.wallet.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

	final private WalletRepository walletRepository;

	@Autowired
	public WalletService(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}

	public List<? extends Wallet> getAllWalletsByOwnerId(String ownerId) {
		return this.walletRepository.getAllWalletsByOwnerId(ownerId);
	}

	public <T extends Wallet> T createWallet(T wallet) {
		return this.walletRepository.createWallet(wallet);
	}

	public String deleteWallet(String walletId) {
		final String deletedWalletId = this.walletRepository.deleteWallet(walletId);

		if (deletedWalletId.length() == 0) {
			throw new WalletNotFoundException(walletId);
		}

		return deletedWalletId;
	}
}

