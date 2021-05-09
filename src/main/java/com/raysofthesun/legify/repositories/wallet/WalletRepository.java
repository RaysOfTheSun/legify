package com.raysofthesun.legify.repositories.wallet;

import com.raysofthesun.legify.models.wallet.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;

import java.util.List;

@Repository
public class WalletRepository {

	final private MongoOperations mongoOperations;

	@Autowired
	public WalletRepository(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public List<? extends Wallet> getAllWalletsByOwnerId(String ownerId) {
		return this.mongoOperations
				.query(Wallet.class)
				.matching(query(where("ownerId").is(ownerId)))
				.all();
	}

	public <T extends Wallet> T createWallet(T wallet) {
		return this.mongoOperations.insert(wallet);
	}

	public String deleteWallet(String walletId) {
		final boolean hasDeletedWallet = this.mongoOperations
				.remove(query(where("id").is(walletId)), Wallet.class)
				.getDeletedCount() >= 1;

		return hasDeletedWallet ? walletId: "";
	}
}
