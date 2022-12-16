package com.example.tripvision.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.team.domain.Team;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface TeamRepository extends JpaRepository<Team,Long>, TeamRepositoryCustom {


}

