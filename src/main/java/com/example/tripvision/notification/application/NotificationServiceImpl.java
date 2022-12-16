package com.example.tripvision.notification.application;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.notification.dao.NotificationRepository;
import com.example.tripvision.notification.domain.Notification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {


	private final NotificationRepository notificationRepository;

	@Override
	public Page<Notification> searchNotification(Pageable pageable, String title) {
		return null;
	}

	@Transactional(readOnly = true)
	public Page<Notification> findAll(Pageable pageable) {
		Page<Notification> notificationList = notificationRepository.findAll(pageable);
		return notificationList;
	}
	@Transactional
	public void deleteAll() {
		// TODO 연관관계 모두 삭제 해주기.
		notificationRepository.deleteAll();
	}


	@Transactional(readOnly = true)
	public Notification findNotification(Long id) {
		return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 프로젝트가 없습니다."));
	}

	@Transactional
	public Notification saveNotification(Notification notification) {
		return notificationRepository.save(notification);
	}


	@Transactional
	public Notification updateNotification(Notification notification) {
		Notification newNotification = notificationRepository.findById(notification.getId())
			.orElseThrow(() -> new RuntimeException("good"));
		newNotification.update(notification);
		return newNotification;
	}

	@Transactional
	public void deleteNotification(Long notificationId) {
		notificationRepository.deleteById(notificationId);
		// 단방향 이면, 따로 연관관계를 삭제해줍시다.
	}
}
