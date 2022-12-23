package com.example.tripvision.project.application;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.SearchCriteria;

public interface ProjectService {

	Page<Project> findAll(Pageable pageable);

	void deleteAll();
	Project findProject(Long id);

	Project saveProject(Project project);
	Project updateProject(Project project);
	void deleteProject(Long teamId, Long projectId);

}
