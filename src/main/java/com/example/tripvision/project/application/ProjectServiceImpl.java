package com.example.tripvision.project.application;



import java.util.ArrayList;
import java.util.List;

import com.example.tripvision.team.dao.TeamRepository;
import com.example.tripvision.team.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
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
		Page<Project> projectList = projectRepository.findAll(pageable);
		return projectList;
	}
	@Transactional
	public void deleteAll() {
		projectRepository.deleteAll();
		taskRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public Project findProject(Long id) {
		return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
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
		Project newProject = projectRepository.findById(project.getId())
			.orElseThrow(() -> new RuntimeException("good"));
		newProject.update(project);
		return newProject;
	}

	@Transactional
	public void deleteProject(Long projectId) {
		projectRepository.deleteById(projectId);
		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
		// 양방향 이면, Cascade 를 이용해서 삭제 해줍시다.
	}

	// Count Query
	@Transactional(readOnly = true)
	@Override
	public Long currentProject(Long memberId) {
//		Long count = projectRepository.currentProject(memberId);
//		return count;
		return 1L;
	}

	@Transactional(readOnly = true)
	@Override
	public Long projectFinance(Long projectId) {
//		Long projectFinance = projectRepository.projectFinance(projectId);
//		return projectFinance;
		return 1L;
	}

	@Transactional(readOnly = true)
	@Override
	public Long totalMemberFinance(Long memberId) {
//		Long totalMember = projectRepository.totalMemberFinance(memberId);
//		return totalMember;
		return 1L;
	}

	@Override
	public List<Member> findProjectMembers(Long teamId,Long memberId) {
//		List<Member> memberList = projectRepository.teamMembers(teamId,memberId);
//		return memberList;
		return new ArrayList<>();
	}

	@Override
	public Budget projectBudget(Long projectId) {
//		Budget budget = projectRepository.projectBudget(projectId);
//		return budget;
		return Budget.builder().build();
	}

	@Override
	public File projectFiles(Long projectId) {
		return null;
	}


}
