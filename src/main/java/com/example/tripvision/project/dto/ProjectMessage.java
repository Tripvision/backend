package com.example.tripvision.project.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectMessage {
	private String message1;
	private String message2;

	@Builder
	public ProjectMessage(String message1, String message2) {
		this.message1 = message1;
		this.message2 = message2;
	}
}
