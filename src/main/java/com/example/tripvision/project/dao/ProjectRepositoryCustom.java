package com.example.tripvision.project.dao;


import com.example.tripvision.project.domain.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectRepositoryCustom {

	Page<Project> findAllProject(Pageable pageable);

}
