package com.example.tripvision.notification.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.notification.domain.Notification;

public interface NotificationRepositoryCustom {

	Page<Notification> search(Pageable pageable, String title);
}
