package com.example.tripvision.budget.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BudgetMessage {
	private String message1;
	private String message2;

	@Builder
	public BudgetMessage(String message1, String message2) {
		this.message1 = message1;
		this.message2 = message2;
	}
}