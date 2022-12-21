package com.example.tripvision.budget.application;


import com.example.tripvision.project.dao.ProjectRepository;

import com.example.tripvision.project.domain.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.budget.dao.BudgetRepository;
import com.example.tripvision.budget.domain.Budget;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetSearchServiceImpl implements BudgetSearchService {

	private final BudgetRepository budgetRepository;
	private final ProjectRepository projectRepository;

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
		// 연관관계(Project Bulk 연산 필요)
		budgetRepository.deleteAll();
	}

	/*
	단일 조회 완
	 */
	@Transactional(readOnly = true)
	public Budget findBudget(Long projectId, Long budgetId) {

		Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new RuntimeException("not found budget"));

		checkRelationProject(projectId, budget);

		return budget;
	}
	/*
	등록 완
	 */
	@Transactional
	public Budget saveBudget(Budget budget) {

		Project project = projectRepository.findById(budget.getProject().getId()).orElseThrow(() -> new RuntimeException("not found entity"));

		if (project.hasBudget()){
			throw new RuntimeException("Budget 있습니다.");
		}

		project.updateBudget(budget);

		return budgetRepository.save(budget);
	}

	/*
	수정 완
	 */
	@Transactional
	public Budget updateBudget(Long budgetId, Budget budget) {

		Budget newBudget = budgetRepository.findById(budgetId)
			.orElseThrow(() -> new RuntimeException("not found Budget"));

		checkRelationProject(budget.getProject().getId(), newBudget);

		newBudget.update(budget);
		return newBudget;
	}

	/*
	삭제 완
	 */
	@Transactional
	public void deleteBudget(Long projectId, Long budgetId) {

		Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new RuntimeException("budget not found"));

		checkRelationProject(projectId, budget);

		Project project = budget.getProject();
		project.updateBudget(null);

		budgetRepository.deleteById(budgetId);
		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
	}

	private void checkRelationProject(Long projectId, Budget budget) {
		if (!budget.isMatchProjectId(projectId)){
			throw new RuntimeException("project id not found");
		}
	}
}
