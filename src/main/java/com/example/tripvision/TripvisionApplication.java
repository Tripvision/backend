package com.example.tripvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/***
 * EnableAspectJAutoProxy : Aop 설정
 *
 *
 */

@EnableAspectJAutoProxy
@SpringBootApplication
public class TripvisionApplication {

	// @checkstyle:off
	public static void main(String[] args) {
		SpringApplication.run(TripvisionApplication.class, args);
	}
	// @checkstyle:on

}
