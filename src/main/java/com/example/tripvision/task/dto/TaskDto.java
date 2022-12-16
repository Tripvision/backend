package com.example.tripvision.task.dto;

import javax.validation.constraints.NotNull;

import com.example.tripvision.member.dto.MemberDto;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.task.domain.Task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class TaskDto {

	// 연관관계 오브젝트
	private Long id;
	@NotNull
	private ProjectDto projectDto;
	@NotNull
	private MemberDto memberDto;
	@NotNull
	private String tags;

	@NotNull
	private String title;

	@NotNull
	private String content;

	@NotNull
	private String comment;

	@NotNull
	private String status;

	public Task toEntity() {
		return Task.builder()
			.project(projectDto.toEntity())
			.member(memberDto.toEntity())
			.tags(tags)
			.title(title)
			.content(content)
			.comment(comment)
			.status(status)
			.build();
	}
}
