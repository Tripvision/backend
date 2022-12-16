package com.example.tripvision.budget.dao;

import static com.example.tripvision.project.domain.QProject.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

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
}
