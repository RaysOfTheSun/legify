package com.raysofthesun.legify.wallet.controllers;

import com.raysofthesun.legify.wallet.models.Wallet;
import com.raysofthesun.legify.wallet.services.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/wallets")
public class WalletController {

	final private WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@PutMapping("/create")
	public Wallet createWallet(@RequestBody Wallet wallet) {
		return this.walletService.createWallet(wallet);
	}

	@DeleteMapping("/remove/{walletId}")
	public String deleteWallet(@PathVariable String walletId) {
		return this.walletService.deleteWallet(walletId);
	}

	@GetMapping("/vault/{ownerId}")
	public List<? extends Wallet> getAllWalletsByOwnerId(@PathVariable String ownerId) {
		return this.walletService.getAllWalletsByOwnerId(ownerId);
	}
}
