package com.web.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	/*
	 * @Bean public RequestInterceptor requestTokenBearerInterceptor() { return new
	 * RequestInterceptor() {
	 * 
	 * @Override public void apply(RequestTemplate template) {
	 * JwtAuthenticationToken token = (JwtAuthenticationToken)
	 * SecurityContextHolder.getContext().getAuthentication();
	 * template.header("Authorization", "Bearer " +
	 * token.getToken().getTokenValue()); } }; }
	 */
}
