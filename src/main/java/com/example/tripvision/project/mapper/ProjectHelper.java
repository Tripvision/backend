package com.example.tripvision.project.mapper;

import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.task.domain.Task;
import com.example.tripvision.task.dto.TaskDto;

public class ProjectHelper {


	public static ProjectDto toDto(Project project) {
		return ProjectDto.builder()
			.id(project.getId())
			.title(project.getTitle())
			.dueDate(project.getDueDate())
			.build();
	}
}
