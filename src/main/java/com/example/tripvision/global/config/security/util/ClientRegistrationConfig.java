package com.example.tripvision.global.config.security.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientPropertiesRegistrationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ClientRegistrationConfig {

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository(OAuth2ClientProperties properties) {
		final List<ClientRegistration> registrations = new ArrayList<>(
			OAuth2ClientPropertiesRegistrationAdapter.getClientRegistrations(properties).values());
		// this is the ClientRegistrationRepository that would be used by default configuration
		final ClientRegistrationRepository parent = new InMemoryClientRegistrationRepository(registrations);

		// this lambda is our wrapper around the configuration based ClientRegistrationRepository
		return (registrationId) -> {
			final ClientRegistration clientRegistration = parent.findByRegistrationId(registrationId);
			if (clientRegistration == null) {
				return null;
			}

			// Request 에서
			final HttpServletRequest request = Optional.ofNullable(RequestContextHolder.getRequestAttributes())
				.filter(ServletRequestAttributes.class::isInstance)
				.map(ServletRequestAttributes.class::cast)
				.map(ServletRequestAttributes::getRequest)
				.orElse(null);

			final String query;
			if (request == null || (query = request.getQueryString()) == null) {
				return clientRegistration;
			}

			// Scope 를 쿼리 파라미터로 받습니다.
			//
			final List<String> scopeQueryParam = parseQuery(query).get(OAuth2ParameterNames.SCOPE);
			if (scopeQueryParam == null) {
				return clientRegistration;
			}

			log.error("----------- DynaMic scope -------");

			// Scope 를 공백 기준으로 구분합니다.
			final Set<String> scopes = scopeQueryParam.stream()
				.flatMap((v) -> Arrays.stream(v.split(" ")))
				.collect(Collectors.toSet());

			log.error("----------- DynaMic scope -------");
			scopes.stream().forEach(System.out::println);

			// 구분한 Scope 를 clientRegistration 에 덮어 씌웁니다.
			if (clientRegistration.getScopes().containsAll(scopes)) {
				return clientRegistration;
			}

			//
			final Set<String> resultingScopes = new HashSet<>(scopes);
			resultingScopes.addAll(clientRegistration.getScopes());

			return ClientRegistration.withClientRegistration(clientRegistration)
				.scope(resultingScopes)
				.build();
		};
	}

	private static MultiValueMap<String, String> parseQuery(String query) {
		final MultiValueMap<String, String> result = new LinkedMultiValueMap<>();

		final String[] pairs = query.split("&");
		String[] pair;

		for (String _pair : pairs) {
			pair = _pair.split("=");

			if (pair.length >= 1) {
				final List<String> values = result.computeIfAbsent(URLDecoder.decode(pair[0], StandardCharsets.UTF_8), (k) -> new ArrayList<>());

				if (pair.length >= 2) {
					values.add(URLDecoder.decode(pair[1], StandardCharsets.UTF_8));
				}
			}
		}

		return result;
	}
}
