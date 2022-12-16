package com.example.tripvision.setting.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.setting.domain.Setting;

public interface SettingSearchService {
	public Page<Setting> searchSetting(Pageable pageable, String title);

	public Page<Setting> findAll(Pageable pageable);

	public void deleteAll();
	public Setting findSetting(Long id);

	public Setting saveSetting(Setting setting);
	public Setting updateSetting(Setting setting);
	public void deleteSetting(Long settingId);

}
