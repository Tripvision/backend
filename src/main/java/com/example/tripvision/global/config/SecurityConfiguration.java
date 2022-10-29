package com.example.tripvision.global.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 * Spring Security 설정을 위한 클래스 입니다.
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = "app.security",
	name = "enabled",
	havingValue = "true")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/", "/**").access("permitAll")
			.antMatchers("/h2-console/**").permitAll() // 추가
			.and()
			.csrf() // 추가
			.ignoringAntMatchers("/h2-console/**").disable() // 추가
			.httpBasic();
	}

	// Security 무시하기
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

}
