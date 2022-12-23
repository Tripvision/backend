package com.example.tripvision.project.dao;

import com.example.tripvision.budget.domain.QBudget;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.domain.QProject;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.example.tripvision.budget.domain.QBudget.*;
import static com.example.tripvision.project.domain.QProject.*;

@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

	private final JPAQueryFactory queryFactory;


	@Override
	public Page<Project> findAllProject(Pageable pageable) {

		JPAQuery<Long> countQuery = queryFactory.select(project.count())
			.from(project)
			.join(project.budget, budget).fetchJoin();

		List<Project> content = queryFactory.select(project)
			.from(project)
			.join(project.budget, budget).fetchJoin()
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
	}
}
