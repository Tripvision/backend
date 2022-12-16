package com.example.tripvision.notification.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.notification.domain.Notification;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface NotificationRepository extends JpaRepository<Notification,Long>, NotificationRepositoryCustom {


}

