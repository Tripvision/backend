package com.example.tripvision.budget.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;

public interface BudgetRepositoryCustom {

	Page<Budget> search(Pageable pageable, String title);
	Page<Budget> findAll(Pageable pageable);
}
