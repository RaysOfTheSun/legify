package com.raysofthesun.legify.controllers;

import com.raysofthesun.legify.repositories.wallet.WalletRepository;
import com.raysofthesun.legify.services.wallet.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("WalletController")
public class WalletControllerTests {

	final private MockMvc mockMvc;

	private String deleteUrl;
	private String targetWalletId;

	@MockBean
	private WalletService walletService;

	@Autowired
	public WalletControllerTests(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@BeforeEach
	public void setupTestVariables() {
		this.targetWalletId = "some-wallet-id";
		this.deleteUrl = String.format("/wallets/remove/%s", this.targetWalletId);
	}

	@Test
	@DisplayName("should be able to delete an existing wallet given its id")
	public void successfullyDeleteWallet() throws Exception {
		when(this.walletService.deleteWallet(this.targetWalletId))
				.thenReturn(this.targetWalletId);

		this.mockMvc.perform(delete(this.deleteUrl, this.targetWalletId))
				.andExpect(status().isOk());
	}
}
