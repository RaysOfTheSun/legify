package com.raysofthesun.legify.wallet.services;

import com.raysofthesun.legify.exceptions.models.ErrorConfig;
import com.raysofthesun.legify.wallet.config.WalletErrorConfig;
import com.raysofthesun.legify.wallet.constants.WalletErrorType;
import com.raysofthesun.legify.wallet.exceptions.types.VaultIsEmptyException;
import com.raysofthesun.legify.wallet.exceptions.types.WalletNotFoundException;
import com.raysofthesun.legify.wallet.models.Wallet;
import com.raysofthesun.legify.wallet.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

	final private WalletRepository walletRepository;
	final private WalletErrorConfig walletErrorConfig;
	final private WalletCreatorService walletCreatorService;

	@Autowired
	public WalletService(WalletRepository walletRepository, WalletCreatorService walletCreatorService,
	                     WalletErrorConfig walletErrorConfig) {
		this.walletRepository = walletRepository;
		this.walletErrorConfig = walletErrorConfig;
		this.walletCreatorService = walletCreatorService;
	}

	public List<? extends Wallet> getAllWalletsByOwnerId(String ownerId) {
		final List<? extends  Wallet> walletList = this.walletRepository.getAllWalletsByOwnerId(ownerId);

		if (walletList.size() == 0) {
			throw new VaultIsEmptyException();
		}

		return walletList;
	}

	public Wallet createWallet(Wallet wallet) {
		final Wallet walletToCreate = this.walletCreatorService.makeWalletFromMeta(wallet);
		return this.walletRepository.createWallet(walletToCreate);
	}

	public String deleteWallet(String walletId) {
		final String deletedWalletId = this.walletRepository.deleteWallet(walletId);
		if (deletedWalletId.length() == 0) {
			throw new WalletNotFoundException(
					this.walletErrorConfig.getErrorConfig(WalletErrorType.WALLET_NOT_FOUND));
		}

		return deletedWalletId;
	}
}

