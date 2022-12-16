package com.example.tripvision.notification.domain;

public enum Type {

	TEAM("ACTIVITY","MESSAGE"),
	MEMBER("ACTIVITY", "MESSAGE");

	private final String activity;
	private final String message;

	Type(String activity, String message) {
		this.message = message;
		this.activity = activity;
	}
}
