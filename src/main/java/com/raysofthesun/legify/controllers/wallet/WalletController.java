package com.raysofthesun.legify.controllers.wallet;

import com.raysofthesun.legify.services.wallet.WalletService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/wallets")
public class WalletController {

	final private WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@DeleteMapping("/remove/{walletId}")
	public String deleteWallet(@PathVariable String walletId) {
		return this.walletService.deleteWallet(walletId);
	}
}
