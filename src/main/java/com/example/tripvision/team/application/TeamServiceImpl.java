package com.example.tripvision.team.application;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.project.dao.ProjectRepository;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.task.dao.TaskRepository;
import com.example.tripvision.team.dao.TeamRepository;
import com.example.tripvision.team.domain.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;

	@Transactional(readOnly = true)
	public Page<Team> searchTeam(Pageable pageable, String title) {
		return teamRepository.search(pageable,title);
	}

	@Transactional(readOnly = true)
	public Page<Team> findAll(Pageable pageable) {
		Page<Team> teamList = teamRepository.findAll(pageable);
		return teamList;
	}
	@Transactional
	public void deleteAll() {
		// TODO 연관관계 모두 삭제 해주기.
		teamRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public Team findTeam(Long id) {
		return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}

	@Transactional
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}


	@Transactional
	public Team updateTeam(Team team) {
		Team newTeam = teamRepository.findById(team.getId())
			.orElseThrow(() -> new RuntimeException("good"));
		newTeam.update(team);
		return newTeam;
	}

	@Transactional
	public void deleteTeam(Long teamId) {
		teamRepository.deleteById(teamId);
		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
	}
}
