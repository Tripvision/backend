package com.example.tripvision.setting.mapper;

import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.setting.dto.SettingDto;

public class SettingHelper {


	public static SettingDto toDto(Setting setting) {
		return SettingDto.builder()
			.id(setting.getId())
			.logoUrl(setting.getLogoUrl())
			.title(setting.getTitle())
			.name(setting.getName())
			.type(setting.getType())
			.description(setting.getDescription())
			.dueDate(setting.getDueDate())
			.status(setting.getStatus())
			.notifierType(setting.getNotifierType())
			.projectId(setting.getProject().getId())
			.build();
	}
}
