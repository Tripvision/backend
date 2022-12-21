package com.example.tripvision.project.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.team.domain.Team;
import com.example.tripvision.team.dto.TeamDto;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ProjectDto {

	private Long id;
	@NotNull
	private String title;
	@Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate dueDate;
	private TeamDto teamDto;

	public Project toEntity() {
		if (id == null) {
			return Project.builder()
				.title(title)
				.dueDate(dueDate)
				.team(teamDto.toEntity())
				.build();
		} else {
			return Project.builder()
				.id(id)
				.title(title)
				.dueDate(dueDate)
				.team(teamDto.toEntity())
				.build();
		}

	}

}
