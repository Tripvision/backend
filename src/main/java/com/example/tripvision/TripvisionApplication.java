package com.example.tripvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.tripvision.global.config.AppProperties;

/***
 * EnableAspectJAutoProxy : Aop 설정
 */

@EnableAspectJAutoProxy
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class TripvisionApplication {

	// @checkstyle:off
	public static void main(String[] args) {
		SpringApplication.run(TripvisionApplication.class, args);
	}
	// @checkstyle:on

}
