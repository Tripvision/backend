package com.example.tripvision.budget.application;

import com.example.tripvision.budget.dto.BudgetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;

public interface BudgetSearchService {
	public Page<Budget> searchBudget(Pageable pageable, String title);

	public Page<Budget> findAll(Pageable pageable);

	public void deleteAll();
	public Budget findBudget(Long id);

	public Budget saveBudget(Budget budget);
	public Budget updateBudget(Long budgetId, Budget budget);
	public void deleteBudget(Long budgetId);

}
