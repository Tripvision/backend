package com.example.tripvision.task.mapper;

import com.example.tripvision.member.mapper.MemberHelper;
import com.example.tripvision.project.mapper.ProjectHelper;
import com.example.tripvision.task.domain.Task;
import com.example.tripvision.task.dto.TaskDto;

public class TaskHelper {

	public static TaskDto toDto(Task task) {
		return TaskDto.builder()
			.id(task.getId())
			.projectDto(ProjectHelper.toDto(task.getProject()))
			.memberDto(MemberHelper.toDto(task.getMember()))
			.title(task.getTitle())
			.tags(task.getTags())
			.status(task.getStatus())
			.comment(task.getComment())
			.content(task.getContent())
			.build();
	}
}
