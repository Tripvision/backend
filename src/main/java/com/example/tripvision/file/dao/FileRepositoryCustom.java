package com.example.tripvision.file.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.file.domain.File;

public interface FileRepositoryCustom {

	Page<File> search(Pageable pageable, String title);
}
