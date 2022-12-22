package com.example.tripvision.project.api;

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

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.dto.BudgetDto;
import com.example.tripvision.budget.mapper.BudgetHelper;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.member.dto.MemberDto;
import com.example.tripvision.member.mapper.MemberHelper;
import com.example.tripvision.project.application.ProjectService;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.project.dto.SearchRequest;
import com.example.tripvision.project.mapper.ProjectHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.example.tripvision.project.dto.ProjectDto.*;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
public class ProjectController {
	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @Author Lee Sang Min
	 */
	private final ProjectService projectSearchService;

	/**
	 * figma : My Projects -> Current Project
	 * @param memberId
	 * @param searchRequest
	 * @return
	 */
	@GetMapping("/members/{id}/projects")
	public ResponseEntity<Long> findCurrentProject(@PathVariable("id") Long memberId, SearchRequest searchRequest) {

		Long currentCount = projectSearchService.currentProject(memberId);
		return new ResponseEntity<>(currentCount,HttpStatus.OK);
	}

	/**
	 * figma : My Projects ->  Project Finance
	 * @param memberId
	 * @return
	 */
	@GetMapping("/members/{id}/budgets")
	public ResponseEntity<Long> findAllFinanceByMember(@PathVariable("id") Long memberId) {
		Long currentCount = projectSearchService.totalMemberFinance(memberId);
		return new ResponseEntity<>(currentCount,HttpStatus.OK);
	}

	/**
	 * figma : My Projects ->  Our Client, My Projects-Users
	 * @param memberId
	 * @return
	 */
	@GetMapping("/projects/team/{id}/members")
	public ResponseEntity<List<MemberDto>> findTeamMember(@PathVariable("id") Long teamId, Long memberId) {
		final List<Member> memberList = projectSearchService.findProjectMembers(teamId,memberId);
		final List<MemberDto> findMemberList = memberList.stream().map(member -> MemberHelper.toDto(member)).collect(Collectors.toList());
		return new ResponseEntity<>(findMemberList,HttpStatus.OK);
	}

	/**
	 * figma : My Projects Budget
	 * @return
	 */
	@GetMapping("/projects/{id}/budget")
	public ResponseEntity<BudgetDto> findBudgetByProject(@PathVariable("id") Long projectId) {
		final Budget projectBudget = projectSearchService.projectBudget(projectId);
		final BudgetDto projectBudget1 = BudgetHelper.toDto(projectBudget);
		return new ResponseEntity<>(projectBudget1, HttpStatus.OK);
	}

	/**
	 * figma : My Projects files
	 * @return
	 */
	// @GetMapping("/projects/{id}/files")
	// public ResponseEntity<FileDto> findFilesByProject(@PathVariable("id") Long projectId) {
	// 	final List<File> fileList = projectSearchService.projectFiles(projectId);
	// 	final List<FileDto> fileList1 = fileList
	// 	return new ResponseEntity<>(projectBudget1, HttpStatus.OK);
	// }

	/**
	 * figma : My Projects Activity
	 * @return
	 */
	// @GetMapping("/projects/{id}/budget")
	// public ResponseEntity<BudgetDto> findSettingByProject(@PathVariable("id") Long projectId) {
	// 	final Setting setting = projectSearchService.projectSetting(projectId);
	// 	final BudgetDto projectBudget1 = SettingHelper.toDto(setting);
	// 	return new ResponseEntity<>(projectBudget1, HttpStatus.OK);
	// }

	// 기본 CRUD
	@GetMapping("/projects")
	public ResponseEntity<Page<ProjectDto>> findAllProject(Pageable pageable) {
		final Page<Project> projectList = projectSearchService.findAll(pageable);
		final List<ProjectDto> projectList1 = projectList.stream().map(project -> ProjectHelper.toDto(project)).collect(Collectors.toList());
		return new ResponseEntity<>(new PageImpl<>(projectList1), HttpStatus.OK);
	}

	@DeleteMapping("/projects")
	public ResponseEntity deleteAllProject() {
		projectSearchService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/projects/{id}")
	public ResponseEntity<ProjectDto> findProject(@Valid @PathVariable("id") @Min(1) Long projectId) {
		final Project project = projectSearchService.findProject(projectId);
		return new ResponseEntity<>(ProjectHelper.toDto(project),HttpStatus.OK);
	}

	@PostMapping("/teams/{teamId}/projects")
	public ResponseEntity<ProjectDto> saveProject(@Valid @PathVariable @Min(1) Long teamId,
												  @RequestBody ProjectRequestDto projectDto) {
		final Project project = projectSearchService.saveProject(projectDto.toEntity(teamId));
		return new ResponseEntity<>(ProjectHelper.toDto(project),HttpStatus.CREATED);
	}

	@PutMapping("/teams/{teamId}/projects")
	public ResponseEntity<ProjectDto> updateProject(@Valid @PathVariable @Min(1) Long teamId,
													@RequestBody ProjectDto projectDto) {
		log.info(projectDto.toString());
		final Project project = projectSearchService.updateProject(projectDto.toEntity());
		return new ResponseEntity<>(ProjectHelper.toDto(project),HttpStatus.CREATED);
	}

	@DeleteMapping("/teams/{teamId}/projects")
	public ResponseEntity deleteProject(@Valid @PathVariable @Min(1) Long teamId) {
		projectSearchService.deleteProject(teamId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
