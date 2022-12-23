package com.example.tripvision.project.application;

import com.example.tripvision.team.dao.TeamRepository;
import com.example.tripvision.team.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dao.ProjectRepository;
import com.example.tripvision.task.dao.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final TaskRepository taskRepository;
	private final TeamRepository teamRepository;


	@Transactional(readOnly = true)
	public Page<Project> findAll(Pageable pageable) {
		Page<Project> projectList = projectRepository.findAllProject(pageable);
		return projectList;
	}

	@Transactional
	public void deleteAll() {
		projectRepository.deleteAll();
		taskRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public Project findProject(Long teamId) {
		Team team = Team.builder().id(teamId).build();
		return projectRepository.findByTeam(team).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}

	@Transactional
	public Project saveProject(Project project) {
		Team team = teamRepository.findById(project.getTeam().getId())
			.orElseThrow(() -> new RuntimeException("not found team"));

		if (team.hasProject()) throw new RuntimeException("해당 팀에 프로젝트 이미 있습니다.");

		return projectRepository.save(project);
	}


	@Transactional
	public Project updateProject(Project project) {

		Team team = teamRepository.findTeamLazy(project.getTeam().getId())
			.orElseThrow(() -> new RuntimeException("팀을 찾지 못했습니다."));

		Project updateProject = team.getProject();
		updateProject.update(project);

		return updateProject;
	}

	@Transactional
	public void deleteProject(Long teamId, Long projectId) {
		Project project = projectRepository.findByIdLazy(projectId)
				.orElseThrow(() -> new RuntimeException("프로젝트 못찾음"));

		if (!project.isMatchTeamId(teamId)){
			throw new RuntimeException("프로젝트의 팀 ID가 일치하지 않습니다.");
		}

		project.getBudget().deleteProject();
		project.deleteProject(project.getTeam());
		projectRepository.deleteById(projectId);

		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
		// 양방향 이면, Cascade 를 이용해서 삭제 해줍시다.
	}

}
