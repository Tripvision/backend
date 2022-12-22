package com.example.tripvision.project.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.tripvision.project.domain.NotificationType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.team.domain.Team;
import com.example.tripvision.team.dto.TeamDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class ProjectDto {

	private Long id;
	@NotNull
	private String title;

	@NotNull
	private String name;

	@Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate dueDate;

	@NotNull
	private Boolean status;

	@NotNull
	private String logoUrl;

	@NotNull
	private String description;

	@NotNull
	private NotificationType notificationType;

	@NotNull
	private Long teamId;

	public Project toEntity(){
		return Project.builder()
			.id(id)
			.title(title)
			.name(name)
			.dueDate(dueDate)
			.status(status)
			.logoUrl(logoUrl)
			.description(description)
			.notificationType(notificationType)
			.team(Team.builder().id(teamId).build())
			.build();
	}

	@Getter @Setter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ProjectRequestDto{

		@NotNull
		private String title;

		@NotNull
		private String name;

		@Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
		private LocalDate dueDate;

		@NotNull
		private Boolean status;

		@NotNull
		private String logoUrl;

		@NotNull
		private String description;

		@NotNull
		private NotificationType notificationType;

		@NotNull
		private Long teamId;

		public Project toEntity(Long teamId){
			return Project.builder()
				.title(title)
				.name(name)
				.dueDate(dueDate)
				.status(status)
				.logoUrl(logoUrl)
				.description(description)
				.notificationType(notificationType)
				.team(Team.builder().id(teamId).build())
				.build();
		}
	}
}
