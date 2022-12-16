package com.example.tripvision.counter.api;// package com.example.springdatajpaguide01.counter.api;
//
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.example.springdatajpaguide01.counter.dto.CountRequest;
// import com.example.springdatajpaguide01.member.dao.MemberRepository;
// import com.example.springdatajpaguide01.project.dao.ProjectRepository;
// import com.example.springdatajpaguide01.task.dao.TaskRepository;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
//
// @Validated
// @RequiredArgsConstructor
// @RestController
// @Slf4j
// @RequestMapping(value = "/count")
// public class CountController {
//
// 	private final MemberRepository memberRepository;
// 	private final ProjectRepository projectRepository;
// 	private final TaskRepository taskRepository;
//
// 	@GetMapping("/members")
// 	public ResponseEntity<Page<FileDto>> countProject(CountRequest countRequest) {
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
// 	/**
// 	 * Members 에 대한 모든 의존 도메인을 카운팅 합니다.
// 	 * @see com.example.springdatajpaguide01.task.domain.Task,
// 	 * @see com.example.springdatajpaguide01.notification.domain.Notification,
// 	 * @see com.example.springdatajpaguide01.member.domain.Member,
// 	 * @see com.example.springdatajpaguide01.file.domain.File,
// 	 * @see com.example.springdatajpaguide01.budget.domain.Budget,
// 	 * @see com.example.springdatajpaguide01.activity.TeamActivity,
// 	 * @return
// 	 */
// 	@GetMapping("/members/dependence")
// 	public ResponseEntity<Page<FileDto>> countMemberDependence() {
//
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
// 	/**
// 	 * Projects 에 대한 모든 의존 도메인을 카운팅 합니다.
// 	 * @see com.example.springdatajpaguide01.task.domain.Task,
// 	 * @see com.example.springdatajpaguide01.notification.domain.Notification,
// 	 * @see com.example.springdatajpaguide01.member.domain.Member
// 	 * @see com.example.springdatajpaguide01.file.domain.File,
// 	 * @see com.example.springdatajpaguide01.budget.domain.Budget
// 	 * @see com.example.springdatajpaguide01.activity.TeamActivity
// 	 * @param countRequest
// 	 * @return
// 	 */
// 	@GetMapping("/projects/dependence")
// 	public ResponseEntity<Page<FileDto>> countProjectDependence(CountRequest countRequest) {
// 		CountRequest countDto = memberRepository.
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
// 	/**
// 	 * Project 에 포함된 도메인의 의존 도메인 중 단건을 조회합니다.
// 	 * @param countRequest
// 	 * @return
// 	 */
// 	@GetMapping("/projects/")
// 	public ResponseEntity<Page<FileDto>> countProject(CountRequest countRequest) {
// 		CountRequest countDto = countRequest.
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
// 	@GetMapping("/teams")
// 	public ResponseEntity<Page<FileDto>> countProject(CountRequest countRequest) {
// 		CountRequest countDto = countRequest.
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
//
// 	@GetMapping("/tasks")
// 	public ResponseEntity<Page<FileDto>> countProject(CountRequest countRequest) {
// 		CountRequest countDto = countRequest.
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
// 	@GetMapping("/files")
// 	public ResponseEntity<Page<FileDto>> countProject(CountRequest countRequest) {
// 		CountRequest countDto = countRequest.
// 		return new ResponseEntity<>(new PageImpl<>(fileList1), HttpStatus.OK);
// 	}
//
//
//
//
// }
