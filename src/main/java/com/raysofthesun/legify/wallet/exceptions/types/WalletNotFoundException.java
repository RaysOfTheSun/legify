package com.raysofthesun.legify.wallet.exceptions.types;

import com.raysofthesun.legify.exceptions.models.ErrorConfig;
import com.raysofthesun.legify.exceptions.models.LegifyConfigurableException;

public class WalletNotFoundException extends LegifyConfigurableException {
	public WalletNotFoundException(ErrorConfig errorConfig) {
		super(errorConfig, errorConfig.getTemplate());
	}
}
