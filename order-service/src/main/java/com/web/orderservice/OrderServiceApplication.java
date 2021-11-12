package com.web.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

//	@Bean
//	public RequestInterceptor requestTokenBearerInterceptor() {
//		String token =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
//		return requestTemplate -> {
////			JwtAuthenticationToken token =  (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
////			System.out.println("Token: " + token.getToken().getTokenValue());
////			requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
////			var token = SecurityContextHolder.getContext().getAuthentication();
//			requestTemplate.header("Authorization", token);
////			requestTemplate.header("Authorization", "Bearer " + OAuth2AuthenticatedPrincipal token.getToken().getTokenValue());
//		};
//	}

}
