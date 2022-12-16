package com.example.tripvision.setting.dao;

import java.io.File;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.setting.domain.Setting;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface SettingRepository extends JpaRepository<Setting,Long>, SettingRepositoryCustom {


}

