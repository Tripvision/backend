package com.example.tripvision.project.dao;

import com.example.tripvision.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.project.domain.Project;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface ProjectRepository extends JpaRepository<Project,Long>{

	@Query("select p from Project p join fetch p.team join fetch p.budget where p.id = ?1")
	Optional<Project> findByIdLazy(Long projectId);

	Optional<Project> findByTeam(Team team);
}

