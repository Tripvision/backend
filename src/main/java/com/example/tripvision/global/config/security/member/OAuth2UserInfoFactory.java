package com.example.tripvision.global.config.security.member;

import java.util.Map;

import com.example.tripvision.global.exception.OAuth2AuthenticationProcessingException;
import com.example.tripvision.member.domain.AuthProvider;

public class OAuth2UserInfoFactory {
	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
			return new GoogleOAuth2UserInfo(attributes);
		} else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
			return new FacebookOAuth2UserInfo(attributes);
		} else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
			return new GithubOAuth2UserInfo(attributes);
		// } else if (registrationId.equalsIgnoreCase(AuthProvider.kakao.toString())) {
		// 	return new KakaoOauth2UserInfo(attributes);
		// } else if (registrationId.equalsIgnoreCase(AuthProvider.naver.toString())) {
		// 	return new NaverOauth2UserInfo(attributes);
		} else {
			throw new OAuth2AuthenticationProcessingException(
				"Sorry! Login with " + registrationId + " is not supported yet.");
		}
	}
}
