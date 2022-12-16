package com.example.tripvision.notification.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.notification.domain.Notification;

public interface NotificationService {
	public Page<Notification> searchNotification(Pageable pageable, String title);

	public Page<Notification> findAll(Pageable pageable);

	public void deleteAll();
	public Notification findNotification(Long id);

	public Notification saveNotification(Notification notification);
	public Notification updateNotification(Notification notification);
	public void deleteNotification(Long notificationId);

}
