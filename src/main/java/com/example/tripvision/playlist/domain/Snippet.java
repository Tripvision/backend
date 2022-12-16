package com.example.tripvision.playlist.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Snippet {

	private LocalDateTime publishedAt;
	private String channelId;
	private String title;
	private String description;
	private Thumbnails thumbnails;
	private String channelTitle;
	private String defaultLanguage;
	private Localized localized;
}
