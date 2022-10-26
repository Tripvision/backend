package com.example.tripvision.global.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 * Spring Security 설젇을 위한 클래스 입니다.
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = "app.security",
	name = "enabled",
	havingValue = "true")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 인가 정책 설정
		http
			.authorizeRequests() // 요청에 대한 보안 검사 실행
			.anyRequest().authenticated(); // 어떠한 요청에도 인증을 받도록 설정

		// 인증 정책 설정
		http
			.formLogin(); // formLogin인증 방식을 사용하도록 설정
	}

}
