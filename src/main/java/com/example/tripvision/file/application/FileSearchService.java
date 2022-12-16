package com.example.tripvision.file.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.file.domain.File;

public interface FileSearchService {
	public Page<File> searchFile(Pageable pageable, String title);

	public Page<File> findAll(Pageable pageable);

	public void deleteAll();
	public File findFile(Long id);

	public File saveFile(File file);
	public File updateFile(File file);
	public void deleteFile(Long fileId);

}
