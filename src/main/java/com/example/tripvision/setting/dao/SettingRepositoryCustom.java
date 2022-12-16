package com.example.tripvision.setting.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.setting.domain.Setting;

public interface SettingRepositoryCustom {

	Page<Setting> search(Pageable pageable, String title);
}
