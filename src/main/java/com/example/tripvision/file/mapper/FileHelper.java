package com.example.tripvision.file.mapper;

import com.example.tripvision.file.domain.File;
import com.example.tripvision.file.dto.FileDto;
public class FileHelper {


	public static FileDto toDto(File file) {
		return FileDto.builder()
			.id(file.getId())
			.build();
	}
}
