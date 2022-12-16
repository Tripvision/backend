package com.example.tripvision.setting.mapper;

import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.setting.dto.SettingDto;

public class SettingHelper {


	public static SettingDto toDto(Setting setting) {
		return SettingDto.builder()
			.id(setting.getId())
			.build();
	}
}
