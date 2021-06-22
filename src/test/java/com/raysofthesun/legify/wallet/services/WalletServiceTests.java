package com.raysofthesun.legify.wallet.services;

import com.raysofthesun.legify.exceptions.models.ErrorConfig;
import com.raysofthesun.legify.wallet.config.WalletErrorConfig;
import com.raysofthesun.legify.wallet.constants.WalletErrorType;
import com.raysofthesun.legify.wallet.exceptions.types.WalletNotFoundException;
import com.raysofthesun.legify.wallet.repositories.WalletRepository;
import com.raysofthesun.legify.wallet.services.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("WalletService")
public class WalletServiceTests {

	@Mock
	private WalletRepository walletRepository;

	@Mock
	private WalletErrorConfig walletErrorConfig;

	@InjectMocks
	private WalletService walletService;

	private String targetWalletId;

	@BeforeEach
	public void setupTestVariables() {
		this.targetWalletId = "target-wallet-id";
	}

	@Test
	@DisplayName("should be able to delete an existing wallet given its id")
	public void deleteWallet() {
		when(this.walletRepository.deleteWallet(targetWalletId))
				.thenReturn(targetWalletId);

		assertEquals(this.walletService.deleteWallet(targetWalletId), targetWalletId);
	}

	@Test
	@DisplayName("should throw an WalletNotFoundException when one tries to delete a non-existent wallet")
	public void shouldThrowWhenDeleteWalletDoesNothing() {
		when(this.walletRepository.deleteWallet(targetWalletId))
				.thenReturn("");

		when(this.walletErrorConfig.getErrorConfig(WalletErrorType.WALLET_NOT_FOUND))
				.thenReturn(new ErrorConfig());

		assertThrows(WalletNotFoundException.class,
				() -> this.walletService.deleteWallet(targetWalletId));
	}
}
