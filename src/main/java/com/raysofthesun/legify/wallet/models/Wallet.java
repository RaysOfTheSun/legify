package com.raysofthesun.legify.wallet.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "legify")
public class Wallet {

	@Getter
	final protected String id;

	@Getter
	protected String name = "";

	@Getter
	protected String value = BigDecimal.ZERO.toPlainString();

	@Getter
	protected String type;

	@Getter
	protected String ownerId = "";

	@Getter
	protected String currency = "";

	@Getter
	protected String description = "";

	@Getter
	protected List<String> categories = new ArrayList<>();

	public Wallet() {
		this.id = UUID.randomUUID().toString();
	}

	public Wallet clone(Wallet sourceWallet) {
		this.name = sourceWallet.getName();
		this.ownerId = sourceWallet.getOwnerId();
		this.currency = sourceWallet.getCurrency();
		this.description = sourceWallet.getDescription();

		return this;
	}
}
