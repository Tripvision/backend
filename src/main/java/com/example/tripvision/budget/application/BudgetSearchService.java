package com.example.tripvision.budget.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;

public interface BudgetSearchService {
	Page<Budget> searchBudget(Pageable pageable, String title);
	Page<Budget> findAll(Pageable pageable);
	void deleteAll();
	Budget findBudget(Long projectId, Long budgetId);
	Budget saveBudget(Budget budget);
	Budget updateBudget(Long budgetId, Budget budget);
	void deleteBudget(Long projectId, Long budgetId);

}
