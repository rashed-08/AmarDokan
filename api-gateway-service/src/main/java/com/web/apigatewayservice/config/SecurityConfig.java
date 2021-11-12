package com.web.apigatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity http, 
			ReactiveClientRegistrationRepository clientRegistrationRepository) {
//
//		// Authenticate through configured OpenID Provider
//		http.oauth2Login();
//		// Also logout at the OpenID Connect provider
//		http.logout(logout -> logout.logoutSuccessHandler(new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository)));
//		// Require authentication for all requests
//		http.authorizeExchange().anyExchange().authenticated();
//		http.oauth2ResourceServer().jwt();
//		// Allow showing /home within a frame
//		http.headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
//		http.csrf().disable();
		http.csrf().disable()
        .authorizeExchange()
        .anyExchange()
        .authenticated()
        .and().oauth2Login()
        .and().oauth2ResourceServer().jwt();
		System.out.println("http: " + http);
		return http.build();
	}
}
