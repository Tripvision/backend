package com.example.tripvision.file.mapper;

import com.example.tripvision.file.domain.File;
import com.example.tripvision.file.dto.FileDto;
public class FileHelper {

	public static FileDto toDto(File file) {
		return FileDto.builder()
			.id(file.getId())
			.fileName(file.getFileName())
			.fileSize(file.getFileSize())
			.fileUploader(file.getFileUploader())
			.projectId(file.getProject().getId())
			.teamActivityId(file.getTeamActivity().getId())
			.build();
	}
}
