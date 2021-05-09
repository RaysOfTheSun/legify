package com.raysofthesun.legify.models.owner;

import lombok.Getter;

import java.util.UUID;

final public class Owner {

	@Getter
	final private String id;

	@Getter
	private String firstName;

	@Getter
	private String middleName;

	@Getter
	private String lastName;

	public Owner() {
		this.id = UUID.randomUUID().toString();
	}
}
