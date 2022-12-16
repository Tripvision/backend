package com.example.tripvision.file.api;

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

import com.example.tripvision.file.application.FileSearchService;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.file.dto.FileDto;
import com.example.tripvision.file.mapper.FileHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
public class FileController {
	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @Author Lee Sang Min
	 */
	private final FileSearchService fileSearchService;



	@GetMapping("/files")
	public ResponseEntity<Page<FileDto>> findAllProject(Pageable pageable) {
		final Page<File> fileList = fileSearchService.findAll(pageable);
		final List<FileDto> fileList1 = fileList.stream().map(file -> FileHelper.toDto(file)).collect(Collectors.toList());
		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
	}

	@DeleteMapping("/files")
	public ResponseEntity deleteAllProject() {
		fileSearchService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<FileDto> findProject(@Valid @PathVariable("id") @Min(1) Long fileId) {
		final File file = fileSearchService.findFile(fileId);
		return new ResponseEntity<>(FileHelper.toDto(file),HttpStatus.OK);
	}

	@PostMapping("/files")
	public ResponseEntity<FileDto> saveProject(@RequestBody FileDto fileDto) {
		final File file = fileSearchService.saveFile(fileDto.toEntity());
		return new ResponseEntity<>(FileHelper.toDto(file),HttpStatus.CREATED);
	}

	@PutMapping("/files")
	public ResponseEntity<FileDto> updateProject(@RequestBody FileDto fileDto) {
		log.info(fileDto.toString());
		final File file = fileSearchService.updateFile(fileDto.toEntity());
		return new ResponseEntity<>(FileHelper.toDto(file),HttpStatus.CREATED);
	}

	@DeleteMapping("/files/{id}")
	public ResponseEntity deleteProject(@Valid @PathVariable("id")@Min(1) Long id) {
		fileSearchService.deleteFile(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
