package com.example.tripvision.playlist.util;

public enum REFERENCE {

	PLAYLISTS(
		"/playlists"
	),
	Subscriptions(
		"/subscriptions"
	),
	CHANNELS(
		"/channels"
	),
	;

	private final String url;


	REFERENCE(String url) {
		this.url = url;
	}
}
