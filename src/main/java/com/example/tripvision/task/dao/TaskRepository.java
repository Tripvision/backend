package com.example.tripvision.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.task.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>, TaskRepositoryCustom {

}
