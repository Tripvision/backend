package com.example.tripvision.setting.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.tripvision.project.domain.Project;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;
import com.fasterxml.jackson.annotation.JsonFormat;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
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

	@NotNull
	private Long projectId;

//	private Setting setting;

//	private Budget budget;
//	private ProjectDto projectDto;

	@Builder
	public SettingDto(Long id, String title, String logoUrl, String name, String type, String description, LocalDate dueDate, String notifierType, Boolean status, Long projectId) {
		this.id = id;
		this.title = title;
		this.logoUrl = logoUrl;
		this.name = name;
		this.type = type;
		this.description = description;
		this.dueDate = dueDate;
		this.notifierType = notifierType;
		this.status = status;
		this.projectId = projectId;
	}

	public SettingDto(Setting setting){
		this.id = setting.getId();
		this.logoUrl = setting.getLogoUrl();
		this.title = setting.getTitle();
		this.name = setting.getName();
		this.type = setting.getType();
		this.description = setting.getDescription();
		this.dueDate = setting.getDueDate();
		this.status = setting.getStatus();
		this.notifierType = setting.getNotifierType();
		this.projectId = setting.getProject().getId();
	}

	public Setting toEntity(Project project) {
		if (id == null) {
			return Setting.builder()
				.logoUrl(logoUrl)
				.name(name)
				.type(type)
				.description(description)
				.dueDate(dueDate)
				.notifierType(notifierType)
				.status(status)
				.project(project)
				.build();
		} else {
			return Setting.builder()
				.id(id)
				.build();
		}
	}

	@Getter
	@Setter
	public static class SettingAndProjectDto{

		private String title;
		private ProjectDto projectDto;

		@Builder
		public SettingAndProjectDto(String title, ProjectDto projectDto){
			this.title = title;
			this.projectDto = projectDto;
		}
	}

}
