package com.example.tripvision.budget.application;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.budget.dao.BudgetRepository;
import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetSearchServiceImpl implements BudgetSearchService {

	private final BudgetRepository budgetRepository;

	@Override
	public Page<Budget> searchBudget(Pageable pageable, String title) {
		return null;
	}

	@Transactional(readOnly = true)
	public Page<Budget> findAll(Pageable pageable) {
		Page<Budget> budgetList = budgetRepository.findAll(pageable);
		return budgetList;
	}
	@Transactional
	public void deleteAll() {
		// 연관관계 모두 삭제하기
		budgetRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public Budget findBudget(Long id) {
		return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}

	@Transactional
	public Budget saveBudget(Budget budget) {
		return budgetRepository.save(budget);
	}


	@Transactional
	public Budget updateBudget(Budget budget) {
		Budget newBudget = budgetRepository.findById(budget.getId())
			.orElseThrow(() -> new RuntimeException("good"));
		newBudget.update(budget);
		return newBudget;
	}

	@Transactional
	public void deleteBudget(Long budgetId) {
		budgetRepository.deleteById(budgetId);
		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
	}
}
