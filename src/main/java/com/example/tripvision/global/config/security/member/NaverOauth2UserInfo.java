package com.example.tripvision.global.config.security.member;

import java.util.Map;

public class NaverOauth2UserInfo extends OAuth2UserInfo {

	// JSON형태이기 떄문에 Map을 통해서 데이터를 가져온다.
	Map<String, Object> response = (Map<String, Object>)attributes.get("response");

	public NaverOauth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return (String)response.get("");
	}

	@Override
	public String getName() {
		return (String)response.get("name");
	}

	@Override
	public String getEmail() {
		return (String)response.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String)response.get("profile_image");
	}
}
