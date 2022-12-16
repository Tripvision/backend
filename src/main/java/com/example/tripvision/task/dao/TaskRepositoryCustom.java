package com.example.tripvision.task.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.project.domain.Project;
import com.example.tripvision.task.domain.Task;

public interface TaskRepositoryCustom {

	Page<Task> search(Pageable pageable, String title);

	Page<Task> findAllByProjectId(Long pId);

	Long deleteAllByProjectId(Long id);

	Long countByProjectId(Long id);


}
