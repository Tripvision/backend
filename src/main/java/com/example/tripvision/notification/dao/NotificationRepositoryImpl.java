package com.example.tripvision.notification.dao;

import static com.example.tripvision.project.domain.QProject.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.notification.domain.Notification;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepositoryCustom {

	private final JPAQueryFactory queryFactory;



	private BooleanExpression eqTitle(String title) {
		return title != null ? project.title.contains(title) : null;
	}

	@Override
	public Page<Notification> search(Pageable pageable, String title) {
		return null;
	}
}
