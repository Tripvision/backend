package com.example.tripvision.budget.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.budget.domain.Budget;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface BudgetRepository extends JpaRepository<Budget,Long>, BudgetRepositoryCustom {


}

