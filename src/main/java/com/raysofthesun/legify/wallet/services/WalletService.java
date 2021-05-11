package com.raysofthesun.legify.wallet.services;

import com.raysofthesun.legify.wallet.exceptions.types.WalletNotFoundException;
import com.raysofthesun.legify.wallet.models.Wallet;
import com.raysofthesun.legify.wallet.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

	final private WalletRepository walletRepository;
	final private WalletCreatorService walletCreatorService;

	@Autowired
	public WalletService(WalletRepository walletRepository, WalletCreatorService walletCreatorService) {
		this.walletRepository = walletRepository;
		this.walletCreatorService = walletCreatorService;
	}

	public List<? extends Wallet> getAllWalletsByOwnerId(String ownerId) {
		return this.walletRepository.getAllWalletsByOwnerId(ownerId);
	}

	public Wallet createWallet(Wallet wallet) {
		final Wallet walletToCreate = this.walletCreatorService.makeWalletFromMeta(wallet);
		return this.walletRepository.createWallet(walletToCreate);
	}

	public String deleteWallet(String walletId) {
		final String deletedWalletId = this.walletRepository.deleteWallet(walletId);

		if (deletedWalletId.length() == 0) {
			throw new WalletNotFoundException(walletId);
		}

		return deletedWalletId;
	}
}

