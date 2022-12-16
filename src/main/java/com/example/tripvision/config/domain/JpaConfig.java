package com.example.tripvision.config.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.tripvision")
public class JpaConfig {

	/**
	 * @EnableJpaAuditing : JPA 날짜 관련 빈 올리는 어노테이션
	 * BootApplicaiton 에 등록해줄 수 있지만, 통합테스트 말고는 해당 빈이 올라가지 않기 때문에, 해당 방식으로 빈을 등록해주었습니다.
	 * Setting : https://abbo.tistory.com/321
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(entityManager);
	}
}
