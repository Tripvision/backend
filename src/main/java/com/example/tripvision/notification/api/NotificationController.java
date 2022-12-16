package com.example.tripvision.notification.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

import com.example.tripvision.notification.application.NotificationService;
import com.example.tripvision.notification.domain.Notification;
import com.example.tripvision.notification.dto.NotificationDto;
import com.example.tripvision.notification.mapper.NotificationHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
public class NotificationController {
	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @Author Lee Sang Min
	 */
	private final NotificationService notificationService;

	@GetMapping("/notifications")
	public ResponseEntity<Page<NotificationDto>> findAllNotification(Pageable pageable) {
		final Page<Notification> notificationList = notificationService.findAll(pageable);
		final List<NotificationDto> notificationList1 = notificationList.stream().map(noti -> NotificationHelper.toDto(noti)).collect(Collectors.toList());
		return new ResponseEntity<>(new PageImpl<>(notificationList1), HttpStatus.OK);
	}

	@DeleteMapping("/notifications")
	public ResponseEntity deleteAllNotification() {
		notificationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/notifications/{id}")
	public ResponseEntity<NotificationDto> findNotification(@Valid @PathVariable("id") @Min(1) Long notificationId) {
		final Notification notification = notificationService.findNotification(notificationId);
		return new ResponseEntity<>(NotificationHelper.toDto(notification),HttpStatus.OK);
	}

	@PostMapping("/notifications")
	public ResponseEntity<NotificationDto> saveNotification(@RequestBody NotificationDto notificationDto) {
		final Notification notification = notificationService.saveNotification(notificationDto.toEntity());
		return new ResponseEntity<>(NotificationHelper.toDto(notification),HttpStatus.CREATED);
	}

	@PutMapping("/notifications")
	public ResponseEntity<NotificationDto> updateNotification(@RequestBody NotificationDto notificationDto) {
		log.info(notificationDto.toString());
		final Notification notification = notificationService.updateNotification(notificationDto.toEntity());
		return new ResponseEntity<>(NotificationHelper.toDto(notification),HttpStatus.CREATED);
	}

	@DeleteMapping("/notifications/{id}")
	public ResponseEntity deleteNotification(@Valid @PathVariable("id")@Min(1) Long id) {
		notificationService.deleteNotification(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
