package com.example.tripvision.project.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.dto.SearchCriteria;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;

public interface ProjectRepositoryCustom {

	/**
	 * 진행중인 프로젝트에 속한 멤버들을 리턴합니다.
	 */
	public List<Member> teamMembers(Long teamId,Long memberId);

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
	 * 현재 프로젝트의 Budget 을 리턴합니다.
	 */
	Budget projectBudget(Long projectId);

	/**
	 * 현재 프로젝트의 Files 를 리턴합니다.
	 */
	List<File> projectFiles(Long projectId);

	/**
	 * 현재 프로젝트의 Setting 를 리턴합니다.
	 */
	Setting projectSetting(Long projectId);



}
