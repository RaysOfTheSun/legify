package com.raysofthesun.legify.wallet.config;

import com.raysofthesun.legify.exceptions.models.ErrorConfig;
import com.raysofthesun.legify.wallet.constants.WalletErrorType;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "app-wallet-errors")
public class WalletErrorConfig {

	@Setter
	private Map<String, ErrorConfig> errors;

	public ErrorConfig getErrorConfig(WalletErrorType walletErrorType) {
		return errors.get(walletErrorType.name());
	}
}
