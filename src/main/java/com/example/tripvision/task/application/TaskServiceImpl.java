package com.example.tripvision.task.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.project.dao.ProjectRepository;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.task.dao.TaskRepository;
import com.example.tripvision.task.domain.Task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
	private final TaskRepository taskRepository;

	private final ProjectRepository projectRepository;

	private final MemberRepository memberRepository;

	@Transactional(readOnly = true)
	public List<Task> findAll() {
		List<Task> taskList = taskRepository.findAll();
		if(taskList.isEmpty() == true) {
			new Exception("조회된 태스크들이 없습니다.");
		}
		return taskList;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllByProjectId(Long pId) {
		List<Task> taskList = taskRepository.findAllByProjectId(pId).toList();
		if(taskList.isEmpty() == true) {
			new Exception("조회된 태스크들이 없습니다.");
		}
		return taskList;
	}



	// Collection Put is Not Supported

	@Transactional
	public void deleteAll() {
		taskRepository.deleteAll();
	}

	@Transactional
	public Long deleteAllByProjectId(Long id) {
		Long count = taskRepository.deleteAllByProjectId(id);
		return count;
	}

	public Long countByProjectId(Long id) {
		return taskRepository.countByProjectId(id);
	}

	@Transactional(readOnly = true)
	public Task findTask(Long id) {
		return taskRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}



	@Transactional
	public Task saveTask(Task task) {
		Project project = projectRepository.findById(task.getProject().getId())
			.orElseThrow(() -> new RuntimeException("프로젝트를 찾을 수 없습니다."));
		log.error(task.toString());
		task.setProject(project);
		return taskRepository.save(task);
	}
	@Transactional
	public Task updateTask(Task task) {
		Task newTask = taskRepository.findById(task.getId())
			.orElseThrow(() -> new RuntimeException("해당 태스크를 찾지 못했습니다."));
		newTask.updateTask(task);
		return newTask;
	}
	@Transactional
	public void deleteTask(Long taskID) {
		taskRepository.deleteById(taskID);
	}
}
