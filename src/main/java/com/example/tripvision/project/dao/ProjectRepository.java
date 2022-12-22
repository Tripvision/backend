package com.example.tripvision.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.project.domain.Project;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface ProjectRepository extends JpaRepository<Project,Long>{


}

