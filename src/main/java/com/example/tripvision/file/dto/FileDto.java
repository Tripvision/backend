package com.example.tripvision.file.dto;

import javax.validation.constraints.NotNull;

import com.example.tripvision.activity.TeamActivity;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.ProjectDto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class FileDto {

	private Long id;

	@NotNull
	private String fileName;

	@NotNull
	private Integer fileSize;

	@NotNull
	private String fileUploader;

//	private ProjectDto projectDto;
	@NotNull
	private Long projectId;

	@NotNull
	private Long teamActivityId;

	@Builder
	private FileDto(Long id, String fileName, Integer fileSize, String fileUploader, Long projectId, Long teamActivityId) {
		this.id = id;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileUploader = fileUploader;
		this.projectId = projectId;
		this.teamActivityId = teamActivityId;
	}

	public FileDto(File file){
		this.id = file.getId();
		this.fileName = file.getFileName();
		this.fileSize = file.getFileSize();
		this.fileUploader = file.getFileUploader();
		this.projectId = file.getProject().getId();
		this.teamActivityId = file.getProject().getId();
	}

	public File toEntity(Project project, TeamActivity teamActivity) {
		if (id == null) {
			return File.builder()

				.build();
		} else {
			return File.builder()
				.id(id)
				.fileName(fileName)
				.fileSize(fileSize)
				.fileUploader(fileUploader)
				.project(project)
				.teamActivity(teamActivity)
				.build();
		}

	}

	@Getter
	@Setter
	public static class FileAndProjectDto{

		private ProjectDto projectDto;

		@Builder
		private FileAndProjectDto(ProjectDto projectDto){
			this.projectDto = projectDto;
		}
	}

}
