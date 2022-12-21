package com.example.tripvision.team.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.memberteam.MemberTeam;
import com.example.tripvision.project.dto.ProjectDto;
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
public class TeamDto {

	private Long id;

	@NotNull
	private String title;

	private ProjectDto projectDto;

	private Team team;

	private List<MemberTeam> memberTeamList;

	public Team toEntity() {
		if (id == null) {
			return Team.builder()
				.title(title)
				.build();
		} else {
			return Team.builder()
				.id(id)
				.build();
		}

	}

}
