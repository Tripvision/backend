package com.example.tripvision.project.dao;

import static com.example.tripvision.project.domain.QProject.*;
import static com.example.tripvision.memberteam.QMemberTeam.*;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.setting.domain.Setting;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Member> teamMembers(Long teamId, Long memberId) {

		List<Member> result = queryFactory
			.select(memberTeam.member).distinct()
			.from(project)
			.innerJoin(memberTeam)
			.on(project.team.id.eq(memberTeam.team.id))
			.where(eqTeamId(teamId)
			.and(memberTeam.member.id.ne(memberId)))
			.fetch();
		return result;
	}

	// @Override
	// public Page<Project> search(List<SearchCriteria> criteriaList,Pageable pageable) {
	//
	// 	List<Member> result = queryFactory
	// 		.select(memberTeam.member())
	// 		.from(project)
	// 		.on(project.team().id.eq(memberTeam.team().id))
	// 		.innerJoin(memberTeam.team())
	// 		.fetch();
	// 	return new PageImpl<>(result.getResults(), pageable, result.getTotal());
	// }

	@Override
	public Long currentProject(Long memberId) {
		Long currentCount = queryFactory.select(project.count())
			.from(project)
			.where(statusComplete(),
				project.member.id.eq(memberId))
			.fetchOne();
		return currentCount;
	}

	@Override
	public Long projectFinance(Long projectId) {
		Long projectFinance = Long.valueOf(queryFactory.select(project.budget.value)
			.from(project)
			.where(project.id.eq(projectId))
			.fetchOne());
		return projectFinance;
	}

	@Override
	public Long totalMemberFinance(Long memberId) {
		Long memberTotalFinance = Long.valueOf(queryFactory.select(project.budget.value.sum())
			.from(project)
			.where(project.member.id.eq(memberId))
			.fetchOne());
		return memberTotalFinance;
	}

	@Override
	public Budget projectBudget(Long projectId) {
		Budget budget = queryFactory.select(project.budget)
			.from(project)
			.where(eqProjectId(projectId))
			.fetchOne();
		return budget;
	}

	@Override
	public List<File> projectFiles(Long projectId) {
		return null;
	}

	// @Override
	// public List<File> projectFiles(Long projectId) {
	// 	List<File> fileList = queryFactory.select(project.file())
	// 		.from(project)
	// 		.where(eqProjectId(projectId))
	// 		.fetch();
	// 	return fileList;
	// }

	@Override
	public Setting projectSetting(Long projectId) {
		Setting setting = queryFactory.select(project.setting)
			.from(project)
			.where(eqProjectId(projectId))
			.fetchOne();
		return setting;
	}

	@Override
	public void bulkUpdateProjectBudget(Budget budget) {

	}

	private BooleanExpression eqTeamId(Long teamId) {
		return teamId != null ? project.team.id.eq(teamId) : null;
	}

	private BooleanExpression eqProjectId(Long projectId) {
		return projectId != null ? project.id.eq(projectId) : null;
	}

	private BooleanExpression eqTitle(String title) {
		return title != null ? project.title.contains(title) : null;
	}

	private BooleanExpression statusComplete() {
		return project.status.contains("Competed");
	}







}
