package com.example.tripvision.budget.mapper;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.dto.BudgetDto;

public class BudgetHelper {


	public static BudgetDto toDto(Budget budget) {
		return BudgetDto.builder()
			.id(budget.getId())
			.dueDate(budget.getDueDate())
			.usage(budget.getUsage())
			.notes(budget.getNotes())
			.value(budget.getValue())
			.allow(budget.getAllow())
			.notes(budget.getNotes())
			.projectId(budget.getProject().getId())
			.build();
	}

	public static BudgetDto.Abc toAbcDto(Budget budget){
		return BudgetDto.Abc.builder()
			.note(budget.getNotes())
			.value(budget.getValue())
			.build();
	}
}
