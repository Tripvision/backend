package com.example.tripvision.global.config.resttemplate;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ResTemplateConfig {

	private final RestTemplateBuilder restTemplateBuilder;


	@Bean
	public RestTemplate youtubeRestTemplate() {
		return restTemplateBuilder
			//.additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
			//.errorHandler(new RestTemplateErrorHandler())
			.setConnectTimeout(Duration.ofMinutes(5))
			.build();
	};

	@Bean
	public RestTemplate calenderRestTemplate() {
		return restTemplateBuilder.rootUri("https://www.googleapis.com/calender/v3/")
			.additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
			//.errorHandler(new RestTemplateErrorHandler())
			.setConnectTimeout(Duration.ofMinutes(3))
			.build();
	}
}
