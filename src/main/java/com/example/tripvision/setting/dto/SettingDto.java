package com.example.tripvision.setting.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;
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
public class SettingDto {

	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String logoUrl;

	@NotNull
	private String name;

	@NotNull
	private String type;

	@NotNull
	private String description;

	@Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate dueDate;

	@NotNull
	private String notifierType;

	@NotNull
	private Boolean status;

	private Setting setting;

	private Budget budget;
	private ProjectDto projectDto;


	public Setting toEntity() {
		if (id == null) {
			return Setting.builder()
				.logoUrl(logoUrl)
				.name(name)
				.type(type)
				.description(description)
				.dueDate(dueDate)
				.notifierType(notifierType)
				.status(status)
				.project(projectDto.toEntity())
				.build();
		} else {
			return Setting.builder()
				.id(id)
				.build();
		}

	}

}
