package com.example.tripvision.task.dao;

import static com.example.tripvision.task.domain.QTask.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.project.domain.QProject;
import com.example.tripvision.task.domain.QTask;
import com.example.tripvision.task.domain.Task;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public Page<Task> search(Pageable pageable, String title) {
		QueryResults<Task> result = queryFactory.selectFrom(task)
			.where(eqTitle(title))
			// .orderBy(orderType(sortElement, order))
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetchResults();
		return new PageImpl<>(result.getResults(), pageable, result.getTotal());
	}

	/**
	 * 프로젝트에 해당하는 태스크들을 모두 조회합니다.
	 * @param pId
	 * @return
	 */
	QTask task = QTask.task;
	QProject project = QProject.project;
	@Override
	public Page<Task> findAllByProjectId(Long pId) {
		List<Task> result = queryFactory.selectFrom(task)
			.where(eqProjectId(pId))
			.fetch();
		return new PageImpl<>(result);
	}

	private BooleanExpression eqTitle(String title) {
		return title != null ? task.title.contains(title) : null;
	}

	private BooleanExpression eqProjectId(Long pId) {
		return pId != null ? task.project.id.eq(pId) : null;
	}


	public Long deleteAllByProjectId(Long id) {
		long execute = queryFactory.delete(task)
			.where(eqProjectId(id)).execute();
		return execute;
	}

	public Long countByProjectId(Long id) {
		long execute = queryFactory
			.select(task.count())
			.from(task)
			.where(eqProjectId(id))
			.fetchOne();
		return execute;
	}

}
