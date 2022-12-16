package com.example.tripvision.setting.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.setting.dao.SettingRepository;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingSearchServiceImpl implements SettingSearchService {

	private final SettingRepository settingRepository;

	@Override
	public Page<Setting> searchSetting(Pageable pageable, String title) {
		return null;
	}

	@Transactional(readOnly = true)
	public Page<Setting> searchTeam(Pageable pageable, String title) {
		return settingRepository.search(pageable,title);
	}

	@Transactional(readOnly = true)
	public Page<Setting> findAll(Pageable pageable) {
		Page<Setting> settingsList = settingRepository.findAll(pageable);
		return settingsList;
	}
	@Transactional
	public void deleteAll() {
		// TODO 연관관계 모두 삭제 해주기.
		settingRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public Setting findSetting(Long id) {
		return settingRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}

	@Transactional
	public Setting saveSetting(Setting setting) {
		return settingRepository.save(setting);
	}


	@Transactional
	public Setting updateSetting(Setting setting) {
		Setting newSetting = settingRepository.findById(setting.getId())
			.orElseThrow(() -> new RuntimeException("good"));
		newSetting.update(setting);
		return newSetting;
	}

	@Transactional
	public void deleteSetting(Long settingId) {
		settingRepository.deleteById(settingId);
		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
	}
}
