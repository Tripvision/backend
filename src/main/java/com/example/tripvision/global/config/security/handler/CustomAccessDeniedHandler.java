package com.example.tripvision.global.config.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	private String clientId;

	//"https://accounts.google.com/o/oauth2/v2/auth?"

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.error("리다이렉트 시킵니다.");;
		String path = "https://accounts.google.com/o/oauth2/v2/auth?"
		+ "client_id=430708861260-tq9qno85vskg634mqd1nubakdk6j6s6b.apps.googleusercontent.com&"
			+ "redirect_uri=http://localhost:8080/oauth2/callback/google&"
			+ "response_type=code&"
			+ "scope=https://www.googleapis.com/auth/youtube&"
			+ "access_type=offline&"
			+ "include_granted_scopes=true";
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", path);
		response.sendRedirect(
			"https://accounts.google.com/o/oauth2/v2/auth?"
				+ "client_id=430708861260-tq9qno85vskg634mqd1nubakdk6j6s6b.apps.googleusercontent.com&"
				+ "redirect_uri=http://localhost:8080/oauth2/callback/google&"
				+ "response_type=code&"
				+ "scope=https://www.googleapis.com/auth/youtube&"
				+ "access_type=offline&"
				+ "include_granted_scopes=true"
		);
		// response.setHeader("my-header","hello");
		// response.sendRedirect("http://localhost:3000");
		if (accessDeniedException.getMessage().equalsIgnoreCase("Insufficient scope for this resource")) {
			response.sendRedirect(
				"https://accounts.google.com/o/oauth2/v2/auth?"
					+ "client_id=" + clientId
					+ "&redirect_uri=http://localhost:8080/oauth2/callback/google"
					+ "&response_type=code"
					+ "&scope=https://www.googleapis.com/auth/youtube.readonly"
					+ "&access_type=code"
					+ "&include_granted_scopes=true"
			);
		}
	}
}
