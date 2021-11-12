package com.web.orderservice.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
	
	private final String AUTHORIZATION_HEADER = "Authorization";
	
	public static String getBearerTokenHeader() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
	}

	@Override
	public void apply(RequestTemplate template) {
		template.header(AUTHORIZATION_HEADER, getBearerTokenHeader());

	}

}
