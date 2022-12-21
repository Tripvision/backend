package com.example.tripvision.budget.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripvision.budget.application.BudgetSearchService;
import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.dto.BudgetDto;
import com.example.tripvision.budget.mapper.BudgetHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
public class BudgetController {
	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @Author Lee Sang Min
	 */
	private final BudgetSearchService budgetSearchService;


	@GetMapping("/budgets")
	public ResponseEntity<Page<BudgetDto>> findAllBudgets(Pageable pageable) {
		final Page<Budget> budgetList = budgetSearchService.findAll(pageable);
		final List<BudgetDto> budgetList1 = budgetList.stream().map(budget -> BudgetHelper.toDto(budget)).collect(Collectors.toList());
		return new ResponseEntity<>(new PageImpl<>(budgetList1), HttpStatus.OK);
	}

	@DeleteMapping("/budgets")
	public ResponseEntity deleteAllBudgets() {
		budgetSearchService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/budgets/{id}")
	public ResponseEntity<BudgetDto> findBudget(@Valid @PathVariable("id") @Min(1) Long budgetId) {
		final Budget budget = budgetSearchService.findBudget(budgetId);
		return new ResponseEntity<>(BudgetHelper.toDto(budget),HttpStatus.OK);
	}

	@PostMapping("/budgets")
	public ResponseEntity<BudgetDto> saveBudget(@RequestBody BudgetDto budgetDto) {
		final Budget budget = budgetSearchService.saveBudget(budgetDto.toEntity());
		return new ResponseEntity<>(BudgetHelper.toDto(budget),HttpStatus.CREATED);
	}

	@PutMapping("/budgets/{budgetId}")
	public ResponseEntity<BudgetDto> updateBudget(@PathVariable Long budgetId,
												   @RequestBody BudgetDto budgetDto) {
		log.info(budgetDto.toString());
		final Budget budget = budgetSearchService.updateBudget(budgetId, budgetDto.toEntity());
		return new ResponseEntity<>(BudgetHelper.toDto(budget),HttpStatus.CREATED);
	}

	@DeleteMapping("/budgets/{id}")
	public ResponseEntity deleteBudget(@Valid @PathVariable("id")@Min(1) Long id) {
		budgetSearchService.deleteBudget(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
