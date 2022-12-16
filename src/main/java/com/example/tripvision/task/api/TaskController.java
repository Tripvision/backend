package com.example.tripvision.task.api;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

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

import com.example.tripvision.project.domain.Project;
import com.example.tripvision.task.application.TaskService;
import com.example.tripvision.task.domain.Task;
import com.example.tripvision.task.dto.TaskDto;
import com.example.tripvision.task.mapper.TaskHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@Validated
public class TaskController {

	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @see  Project pid
	 */

	private final TaskService taskService;


	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDto>> findAllTasks() {
		List<Task> taskList = taskService.findAll();
		List<TaskDto> taskDtoList = taskList.stream().map(task -> TaskHelper.toDto(task)).collect(Collectors.toList());
		return new ResponseEntity<>(taskDtoList, HttpStatus.OK);
	}

	/**
	 * My Projects Targets
	 * @return
	 */
	@GetMapping("/projects/{pId}/tasks")
	public ResponseEntity<List<TaskDto>> findAllByProjectId(@PathVariable @Min(1) Long pId) {
		List<Task> taskList = taskService.findAllByProjectId(pId);
		List<TaskDto> taskDtoList = taskList.stream().map(task -> TaskHelper.toDto(task)).collect(Collectors.toList());
		return new ResponseEntity<>(taskDtoList, HttpStatus.OK);
	}


	@DeleteMapping("/tasks")
	public ResponseEntity deleteAllTasks() {
		taskService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/projects/{id}/tasks")
	public ResponseEntity<String> deleteAllByProjectId(@PathVariable @Min(1) Long id) {
		Long execute = taskService.deleteAllByProjectId(id);
		return new ResponseEntity<>(execute.toString()+"건 삭제 완료.",HttpStatus.OK);
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<TaskDto> findProject(@PathVariable("id") @Min(1) Long taskId) {
		// TODO 1. dto 로 바꿔서 내보내주면 된다 ( 변환은 컨트롤러에서 하자 )
		Task task = taskService.findTask(taskId);
		return new ResponseEntity<>(TaskHelper.toDto(task),HttpStatus.OK);
	}

	@PostMapping("/tasks")
	public ResponseEntity<TaskDto> saveProject(@RequestBody TaskDto taskDto) {
		log.error(taskDto.toString());
		Task task = taskService.saveTask(taskDto.toEntity());
		return new ResponseEntity<>(TaskHelper.toDto(task),HttpStatus.CREATED);
	}


	@PutMapping("/tasks")
	public ResponseEntity<TaskDto> updateProject(@RequestBody TaskDto taskDto) {
		Task task = taskService.updateTask(taskDto.toEntity());
		return new ResponseEntity<>(TaskHelper.toDto(task),HttpStatus.CREATED);
	}


	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable("id")@Min(1) Long id) {
		taskService.deleteTask(id);
		return new ResponseEntity("삭제가 완료되었습니다.",HttpStatus.NO_CONTENT);
	}

}

