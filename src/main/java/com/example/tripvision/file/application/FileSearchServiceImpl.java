package com.example.tripvision.file.application;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.file.domain.File;
import com.example.tripvision.file.dao.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileSearchServiceImpl implements FileSearchService {

	private final FileRepository fileRepository;

	@Override
	public Page<File> searchFile(Pageable pageable, String title) {
		return null;
	}

	@Transactional(readOnly = true)
	public Page<File> findAll(Pageable pageable) {
		Page<File> fileList = fileRepository.findAll(pageable);
		return fileList;
	}
	@Transactional
	public void deleteAll() {
		// TODO 연관관계 모두 삭제 해주기.
		fileRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public File findFile(Long id) {
		return fileRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}

	@Transactional
	public File saveFile(File file) {
		return fileRepository.save(file);
	}


	@Transactional
	public File updateFile(File file) {
		File newFile = fileRepository.findById(file.getId())
			.orElseThrow(() -> new RuntimeException("good"));
		newFile.update(file);
		return newFile;
	}

	@Transactional
	public void deleteFile(Long fileId) {
		fileRepository.deleteById(fileId);
	}
}
