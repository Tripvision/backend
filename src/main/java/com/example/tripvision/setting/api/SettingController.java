package com.example.tripvision.setting.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.tripvision.setting.application.SettingSearchService;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.setting.dto.SettingDto;
import com.example.tripvision.setting.mapper.SettingHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
public class SettingController {
	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @Author Lee Sang Min
	 */
	private final SettingSearchService settingSearchService;

	@GetMapping("/settings")
	public ResponseEntity<Page<SettingDto>> findAllProject(Pageable pageable) {
		final Page<Setting> settingList = settingSearchService.findAll(pageable);
		final List<SettingDto> settingList1 =
			settingList.stream().map(setting -> SettingHelper.toDto(setting)).collect(Collectors.toList());
		return new ResponseEntity<>(new PageImpl<>(settingList1), HttpStatus.OK);
	}

	@DeleteMapping("/settings")
	public ResponseEntity deleteAllProject() {
		settingSearchService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/settings/{id}")
	public ResponseEntity<SettingDto> findProject(@Valid @PathVariable("id") @Min(1) Long settingId) {
		final Setting setting = settingSearchService.findSetting(settingId);
		return new ResponseEntity<>(SettingHelper.toDto(setting),HttpStatus.OK);
	}

	@PostMapping("/settings")
	public ResponseEntity<SettingDto> saveProject(@RequestBody SettingDto settingDto) {
		final Setting setting = settingSearchService.saveSetting(settingDto.toEntity());
		return new ResponseEntity<>(SettingHelper.toDto(setting),HttpStatus.CREATED);
	}

	@PutMapping("/settings")
	public ResponseEntity<SettingDto> updateSetting(@RequestBody SettingDto settingDto) {
		log.info(settingDto.toString());
		final Setting setting = settingSearchService.updateSetting(settingDto.toEntity());
		return new ResponseEntity<>(SettingHelper.toDto(setting),HttpStatus.CREATED);
	}

	@DeleteMapping("/settings/{id}")
	public ResponseEntity deleteSetting(@Valid @PathVariable("id")@Min(1) Long id) {
		settingSearchService.deleteSetting(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
