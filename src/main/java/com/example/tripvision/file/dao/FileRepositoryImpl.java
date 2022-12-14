package com.example.tripvision.file.dao;

import static com.example.tripvision.project.domain.QProject.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.file.domain.File;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepositoryCustom {

	private final JPAQueryFactory queryFactory;



	private BooleanExpression eqTitle(String title) {
		return title != null ? project.title.contains(title) : null;
	}

	@Override
	public Page<File> search(Pageable pageable, String title) {
		return null;
	}
}
