package com.example.tripvision.task.application;

import java.util.List;

import com.example.tripvision.task.domain.Task;

public interface TaskService {
	public List<Task> findAll();
	public List<Task> findAllByProjectId(Long pId);
	public void deleteAll();
	public Task findTask(Long id);
	public Task saveTask(Task task);
	public Task updateTask(Task task);
	public void deleteTask(Long taskID);

	public Long deleteAllByProjectId(Long id);

	public Long countByProjectId(Long id);
}
