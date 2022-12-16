package com.example.tripvision.project.dto;

import javax.validation.constraints.AssertTrue;

import lombok.Data;

@Data
public class SearchRequest {
	@AssertTrue
	private Boolean current;
}
