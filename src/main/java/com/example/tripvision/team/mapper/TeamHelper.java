package com.example.tripvision.team.mapper;

import com.example.tripvision.team.domain.Team;
import com.example.tripvision.team.dto.TeamDto;

public class TeamHelper {

	public static TeamDto toDto(Team team) {
		return TeamDto.builder()
			.id(team.getId())
			.title(team.getTitle())
			.build();
	}
}
