package com.example.tripvision.budget.dao;

import static com.example.tripvision.budget.domain.QBudget.*;
import static com.example.tripvision.project.domain.QProject.*;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

@RequiredArgsConstructor
public class BudgetRepositoryImpl implements BudgetRepositoryCustom {

	private final JPAQueryFactory queryFactory;



	private BooleanExpression eqTitle(String title) {
		return title != null ? project.title.contains(title) : null;
	}

	@Override
	public Page<Budget> search(Pageable pageable, String title) {
		return null;
	}

	@Override
	public Page<Budget> findAll(Pageable pageable) {

		JPAQuery<Long> countQuery = queryFactory.select(budget.count())
			.from(budget)
			.join(budget.project, project).fetchJoin();

		List<Budget> content = queryFactory.select(budget)
			.from(budget)
			.join(budget.project, project).fetchJoin()
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
	}
}
