package com.raysofthesun.legify.services.wallet;

import com.raysofthesun.legify.exceptions.wallet.WalletNotFoundException;
import com.raysofthesun.legify.repositories.wallet.WalletRepository;
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

		assertThrows(WalletNotFoundException.class,
				() -> this.walletService.deleteWallet(targetWalletId));
	}
}
