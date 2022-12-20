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

import static com.example.tripvision.budget.dto.BudgetDto.*;

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


	/*
	그 뭐고 그 완전 전체 Budget 조회 말고 해당 프로젝트에 대한 Budget 조회도 필요한가? 아니네 어차피 1대1이니까
	화면에 맞는(필요한) select api 하나 있고 rest api 위한 select 필요.(조건 조회)
	 */

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

	@GetMapping("/projects/{projectId}/budgets/{budgetId}")
	public ResponseEntity<BudgetDto> findBudget(@Valid @PathVariable @Min(1) Long projectId,
												@Valid @PathVariable @Min(1) Long budgetId) {
		final Budget budget = budgetSearchService.findBudget(projectId, budgetId);
		return new ResponseEntity<>(BudgetHelper.toDto(budget),HttpStatus.OK);
	}

	@PostMapping("/projects/{projectId}/budgets")
	public ResponseEntity<BudgetDto> saveBudget(@PathVariable Long projectId,
												@RequestBody BudgetRequestDto requestDto) {
		final Budget budget = budgetSearchService.saveBudget(requestDto.toEntity(projectId));
		return new ResponseEntity<>(BudgetHelper.toDto(budget),HttpStatus.CREATED);
	}

	@PutMapping("/projects/{projectId}/budgets/{budgetId}")
	public ResponseEntity<BudgetDto> updateBudget(@Valid @PathVariable @Min(1) Long projectId,
												  @Valid @PathVariable @Min(1) Long budgetId,
												   @RequestBody BudgetRequestDto requestDto) {
		log.info(requestDto.toString());
		final Budget budget = budgetSearchService.updateBudget(budgetId, requestDto.toEntity(projectId));
		return new ResponseEntity<>(BudgetHelper.toDto(budget),HttpStatus.CREATED);
	}

	@DeleteMapping("/projects/{projectId}/budgets/{budgetId}")
	public ResponseEntity deleteBudget(@Valid @PathVariable @Min(1) Long projectId,
									   @Valid @PathVariable @Min(1) Long budgetId) {
		budgetSearchService.deleteBudget(projectId, budgetId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
