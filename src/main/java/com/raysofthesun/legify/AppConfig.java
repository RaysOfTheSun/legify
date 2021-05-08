package com.raysofthesun.legify;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

	@Bean
	MongoClientFactoryBean appMongoClient() {
		MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();
		mongoClientFactoryBean.setHost("localhost");

		return mongoClientFactoryBean;
	}

	@Bean
	@Autowired
	MongoOperations appMongoOperations(MongoClient appMongoClient) {
		return new MongoTemplate(appMongoClient, "legify");
	}
}

