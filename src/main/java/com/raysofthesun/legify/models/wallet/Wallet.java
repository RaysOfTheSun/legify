package com.raysofthesun.legify.models.wallet;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collation = "legify")
public class Wallet {

	@Getter
	final private String id;

	@Getter
	private String name;

	@Getter
	private String value;

	@Getter
	private String ownerId;

	@Getter
	private String currency;

	@Getter
	private String description;

	@Getter
	private List<String> categories;

	public Wallet() {
		this.id = UUID.randomUUID().toString();
	}
}
