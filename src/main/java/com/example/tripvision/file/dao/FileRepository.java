package com.example.tripvision.file.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripvision.file.domain.File;

// https://www.inflearn.com/questions/227764/extends-jparepository-lt-gt-vs-repository-%EC%A7%88%EB%AC%B8
public interface FileRepository extends JpaRepository<File,Long>, FileRepositoryCustom {


}

