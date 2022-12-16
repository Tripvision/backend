package com.example.tripvision.config.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class HandlerConfig {

	/**
	 * Pageable 객체 기본 설정값 커스텀
	 * @return
	 */

	@Bean
	public PageableHandlerMethodArgumentResolverCustomizer customize() {
		return p -> {
			p.setMaxPageSize(10);
			p.setOneIndexedParameters(true);
		};
	}
}
