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

	@GetMapping("/teams/{teamId}/projects")
	public ResponseEntity<ProjectDto> findProject(@Valid @PathVariable @Min(1) Long teamId) {
		final Project project = projectSearchService.findProject(teamId);
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
													@RequestBody ProjectRequestDto projectDto) {
		log.info(projectDto.toString());
		final Project project = projectSearchService.updateProject(projectDto.toEntity(teamId));
		return new ResponseEntity<>(ProjectHelper.toDto(project),HttpStatus.CREATED);
	}

	@DeleteMapping("/teams/{teamId}/projects/{projectId}")
	public ResponseEntity deleteProject(@Valid @PathVariable @Min(1) Long teamId,
										@Valid @PathVariable @Min(1) Long projectId) {
		projectSearchService.deleteProject(teamId, projectId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
