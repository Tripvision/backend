package com.example.tripvision.file.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.dto.BudgetDto;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.setting.dto.SettingDto;
import com.example.tripvision.team.domain.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class FileDto {

	private Long id;

	@NotNull
	private String fileName;

	@NotNull
	private Integer filesize;

	@NotNull
	private String fileUploader;

	private ProjectDto projectDto;

	public File toEntity() {
		if (id == null) {
			return File.builder()

				.build();
		} else {
			return File.builder()
				.id(id)
				.build();
		}

	}

}
