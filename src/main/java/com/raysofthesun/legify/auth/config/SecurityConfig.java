package com.raysofthesun.legify.auth.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app-security")
public class SecurityConfig {

	@Setter
	private String[] ALLOWED_ORIGINS;

	public String[] getAllowedOrigins() {
		final String[] defaultOrigins = {"http://localhost:4200"};
		return this.ALLOWED_ORIGINS != null ? this.ALLOWED_ORIGINS : defaultOrigins;
	}
}
