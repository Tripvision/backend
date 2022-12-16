package com.example.tripvision.playlist.domain;

import java.util.List;

import lombok.Data;

@Data
public class PlayLists {
	private String kind;
	private String etag;
	private String nextPageToken;
	private String prevPageToken;
	private PageInfo pageInfo;
	private List<PlayList> playList;
}
