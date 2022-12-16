package com.example.tripvision.notification.mapper;

import com.example.tripvision.notification.domain.Notification;
import com.example.tripvision.notification.dto.NotificationDto;

public class NotificationHelper {

	public static NotificationDto toDto(Notification notification) {
		return NotificationDto.builder()
			.id(notification.getId())
			.build();
	}
}
