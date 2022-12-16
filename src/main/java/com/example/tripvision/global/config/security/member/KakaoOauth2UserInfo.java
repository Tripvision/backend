package com.example.tripvision.global.config.security.member;

import java.util.Map;

public class KakaoOauth2UserInfo extends OAuth2UserInfo {
	// kakao는 kakao_account에 유저정보가 있다. (email)
	Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
	// kakao_account안에 또 profile이라는 JSON객체가 있다. (nickname, profile_image)
	Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

	public KakaoOauth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return (String)kakaoProfile.get("nick");
	}

	@Override
	public String getName() {
		return (String)kakaoProfile.get("nickname");
	}

	@Override
	public String getEmail() {
		return (String)kakaoAccount.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String)kakaoProfile.get("profile_image_url");
	}
}
