package com.example.tripvision.member.api;

import java.util.List;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripvision.member.application.MemberSearchService;
import com.example.tripvision.member.domain.Member;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberSearchService memberSearchService;

	private static Integer counter = 1;

	// Collection get
	@GetMapping("/members")
	public ResponseEntity<List<Member>> getMemberList() {
		List<Member> memberList = memberSearchService.getMemberList();
		return new ResponseEntity<>(memberList, HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public ResponseEntity<String> getMemberListTest() {
		String message = "member create Message";
		ThreadContext.put("transaction.id", String.valueOf(++counter));
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	// Collection Post is not supported.

	// Collection update is not Supported.

	// Collection delete
	public void deleteMemberList() {

	}
	// Document

	public void getMemeber() {

	}

	public void registerMember() {
	}

	public void updateMember() {
	}

	public void deleteMember() {
	}
}
















