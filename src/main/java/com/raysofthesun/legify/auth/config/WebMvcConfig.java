package com.raysofthesun.legify.auth.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfig implements WebMvcConfigurer {

	private final SecurityConfig securityConfig;

	public WebMvcConfig(SecurityConfig securityConfig) {
		this.securityConfig = securityConfig;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins(this.securityConfig.getAllowedOrigins())
				.allowCredentials(true);
	}
}
