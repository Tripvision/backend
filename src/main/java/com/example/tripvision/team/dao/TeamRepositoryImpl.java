package com.example.tripvision.team.dao;

import static com.example.tripvision.project.domain.QProject.*;
import static com.example.tripvision.team.domain.QTeam.*;

import com.example.tripvision.team.domain.QTeam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.team.domain.Team;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

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

	@Override
	public Optional<Team> findTeamLazy(Long id) {
		return Optional.ofNullable(queryFactory
			.selectFrom(team)
			.join(team.project, project).fetchJoin()
			.where(team.id.eq(id))
			.fetchOne());
	}
}
