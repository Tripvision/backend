package com.example.tripvision.team.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.team.domain.Team;

public interface TeamService {
	public Page<Team> searchTeam(Pageable pageable, String title);

	public Page<Team> findAll(Pageable pageable);

	public void deleteAll();
	public Team findTeam(Long id);

	public Team saveTeam(Team team);
	public Team updateTeam(Team team);
	public void deleteTeam(Long teamId);

}
