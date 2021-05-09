package com.raysofthesun.legify.models.transaction;

import lombok.Getter;

import java.util.UUID;

public class Transaction {

	@Getter
	final private String id;

	@Getter
	private boolean isCredit;

	@Getter
	private String date;

	@Getter
	private String amount;

	@Getter
	private String walletId;

	@Getter
	private String categoryId;

	@Getter
	private String description;

	@Getter
	private String originCurrency;

	public Transaction() {
		this.id = UUID.randomUUID().toString();
	}
}
