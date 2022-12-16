package com.example.tripvision.playlist.domain;

import lombok.Data;

@Data
public class PlayList {

	private String kind;
	private String etag;
	private String id;
	private Snippet snippet;
	private Status status;
	private ContentDetails contentDetails;
	private Player player;
	private Localizations localizations;
}
