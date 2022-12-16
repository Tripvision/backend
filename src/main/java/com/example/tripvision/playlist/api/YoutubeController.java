// package com.example.tripvision.playlist.api;
//
// import java.net.URI;
// import java.util.Collections;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
// import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
// import org.springframework.security.oauth2.core.OAuth2AccessToken;
// import org.springframework.util.LinkedMultiValueMap;
// import org.springframework.util.MultiValueMap;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;
//
// import com.example.tripvision.global.util.HttpEntityGenerator;
// import com.example.tripvision.playlist.domain.PlayLists;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
//
// @Slf4j
// @RestController
// @RequestMapping(value = "/v1/youtube")
// @RequiredArgsConstructor
// public class YoutubeController {
//
// 	private final OAuth2AuthorizedClientManager authorizedClientManager;
//
// 	private final RestTemplate youtubeRestTemplate;
//
// 	@GetMapping("/playlists")
// 	public ResponseEntity<String> getMemberListTest(Authentication authentication,
// 		HttpServletRequest servletRequest,
// 		HttpServletResponse servletResponse
// 	) {
// 		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("google")
// 			.principal(authentication)
// 			.attributes(attrs -> {
// 				attrs.put(HttpServletRequest.class.getName(), servletRequest);
// 				attrs.put(HttpServletResponse.class.getName(), servletResponse);
// 			})
// 			.build();
//
// 		OAuth2AuthorizedClient authorizedClient = this.authorizedClientManager.authorize(authorizeRequest);
// 		OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
//
// 		HttpHeaders headers = new HttpHeaders();
// 		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
// 		headers.set("Authorization", "Bearer "+ accessToken.getTokenValue());
//
// 		MultiValueMap<String,String> defaultParam = new LinkedMultiValueMap<>();
// 		defaultParam.add("part","snippet");
// 		defaultParam.add("maxResult","25");
// 		defaultParam.add("mine",String.valueOf(true));
// 		defaultParam.add("key","AIzaSyCqttcbPHOxOz9eGKBPXD2hV-Rwmsn-pek");
//
// 		URI uri = UriComponentsBuilder.fromUriString("https://www.googleapis.com/youtube/v3/playlists")
// 			.queryParams(defaultParam)
// 			.build().toUri();
//
// 		HttpEntity httpEntity = new HttpEntity(headers);
//
// 		ResponseEntity<String> playLists = youtubeRestTemplate.exchange(
// 			uri,
// 			HttpMethod.GET,
// 			httpEntity,
// 			String.class
// 		);
// 		return playLists;
// 		// Get AccessToken
//
//
//
// 	};
//
// 	// Collection Post is not supported.
//
// 	// Collection update is not Supported.
//
// 	// Collection delete
// 	public void deleteMemberList() {
//
//
//
// 	}
// 	// Document
//
// 	public void getMemeber() {
//
//
// 	}
//
// 	public void registerMember() {
//
//
// 	}
//
// 	public void updateMember() {
// 	}
//
// 	public void deleteMember() {
// 	}
//
// }
