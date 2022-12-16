// package com.example.tripvision.playlist.util;
//
// import java.net.URI;
// import java.util.Objects;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.util.LinkedMultiValueMap;
// import org.springframework.util.MultiValueMap;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
//
// @Slf4j
// @Configuration
// public class UriBuilder {
//
//
// 	@Value("${spring.security.oauth2.client.registration.google.apiKey}")
// 	String key;
//
// 	private static String GOOGLE_KEY;
//
// 	@Value("${spring.security.oauth2.client.registration.google.apiKey}")
// 	public void setNameStatic(String key){
// 		UriBuilder.GOOGLE_KEY = key;
// 	}
//
// 	public static URI myPlayList(){
// 		return getUri();
//
// 		// pageToken
// 	}
//
// 	public static URI myPlayList(MultiValueMap<String,String> queryParams){
//
// 		return getUri();
//
// 		// pageToken
// 	}
//
// 	private static URI getUri() {
// 		MultiValueMap<String,String> defaultParam = new LinkedMultiValueMap<>();
// 		defaultParam.add("part","snippet");
// 		defaultParam.add("maxResult","25");
// 		defaultParam.add("mine",String.valueOf(true));
// 		defaultParam.add("key",GOOGLE_KEY);
//
// 		return UriComponentsBuilder.fromUriString("https://www.googleapis.com/youtube/v3/playlists")
// 			.queryParams(defaultParam)
// 			.build().toUri();
// 	}
// }
