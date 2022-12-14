package com.example.tripvision.project.application;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.SearchCriteria;

public interface ProjectService {

	public Page<Project> findAll(Pageable pageable);

	public void deleteAll();
	public Project findProject(Long id);

	public Project saveProject(Project project);
	public Project updateProject(Project project);
	public void deleteProject(Long projectId);

	/**
	 * 완료된 프로젝트를 제외한 나머지 프로젝트를 리턴합니다.
	 * @return
	 */
	Long currentProject(Long memberId);

	/**
	 * 현재 프로젝트의 예산을 리턴합니다.
	 */
	Long projectFinance(Long projectId);

	/**
	 * 현재 멤버의 전체 프로젝트 예산을 리턴합니다.
	 */
	Long totalMemberFinance(Long memberId);

	/**
	 * 현재 프로젝트의 팀 멤버를 리턴합니다.
	 */
	List<Member> findProjectMembers(Long teamId,Long memberId);

	/**
	 * 현재 프로젝트의 예산을 리턴합니다.
	 * @param projectId
	 * @return
	 */
	Budget projectBudget(Long projectId);

	/**
	 * 현재 프로젝트의 파일들을 리턴합니다.
	 */
	File projectFiles(Long projectId);

}
