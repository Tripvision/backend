package com.example.tripvision.team.dao;

import static com.example.tripvision.project.domain.QProject.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.team.domain.Team;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepositoryCustom {

	private final JPAQueryFactory queryFactory;



	private BooleanExpression eqTitle(String title) {
		return title != null ? project.title.contains(title) : null;
	}

	@Override
	public Page<Team> search(Pageable pageable, String title) {
		return null;
	}
}
