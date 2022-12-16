package com.example.tripvision.budget.mapper;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.dto.BudgetDto;

public class BudgetHelper {


	public static BudgetDto toDto(Budget budget) {
		return BudgetDto.builder()
			.id(budget.getId())
			.usage(budget.getUsage())
			.value(budget.getValue())
			.allow(budget.getAllow())
			.notes(budget.getNotes())
			.build();
	}
}
