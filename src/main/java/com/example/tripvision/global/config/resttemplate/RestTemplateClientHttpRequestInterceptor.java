package com.example.tripvision.global.config.resttemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestTemplateClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

	@NonNull
	@Override
	public ClientHttpResponse intercept(@NonNull final HttpRequest request,
		@NonNull final byte[] body, final @NonNull ClientHttpRequestExecution execution)
		throws IOException {
		loggingRequest(request, body);

		final ClientHttpResponse response = execution.execute(request, body);

		loggingResponse(response);
		return response;
	}

	private void loggingRequest(final HttpRequest request, byte[] body) {
		log.info("=====Request======");
		log.info("Headers: {}", request.getHeaders());
		log.info("Request Method: {}", request.getMethod());
		log.info("Request URI: {}", request.getURI());
		log.info("Request body: {}",
			body.length == 0 ? null : new String(body, StandardCharsets.UTF_8));
		log.info("=====Request======");
	}

	private void loggingResponse(ClientHttpResponse response) throws IOException {
		log.debug(
			"============================response begin==========================================");
		log.debug("Status code  : {}", response.getStatusCode());
		log.debug("Status text  : {}", response.getStatusText());
		log.debug("Headers      : {}", response.getHeaders());
		log.debug("Response body: {}",
			StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		log.debug(
			"=======================response end=================================================");
	}

	// private String getBody(@NonNull final ClientHttpResponse response) throws IOException {
	// 	try (BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()))) {
	// 		return br.readLine();
	// 	}
	// }
}
