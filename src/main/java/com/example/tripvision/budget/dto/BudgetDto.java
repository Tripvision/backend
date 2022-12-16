package com.example.tripvision.budget.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.domain.Usage;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class BudgetDto {

	private Long id;

	private LocalDateTime dueDate;
	@NotNull
	private Usage usage;
	@NotNull
	private String notes;
	@NotNull
	private Integer value;
	@NotNull
	private Boolean allow;

	private ProjectDto projectDto;

	private Budget budget;

	public Budget toEntity() {
		if (id == null) {
			return Budget.builder()

				.build();
		} else {
			return Budget.builder()
				.id(id)
				.build();
		}

	}

}
