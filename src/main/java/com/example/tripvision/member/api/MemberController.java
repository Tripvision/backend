package com.example.tripvision.member.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripvision.global.config.security.CurrentUser;
import com.example.tripvision.global.config.security.member.UserPrincipal;
import com.example.tripvision.global.exception.ResourceNotFoundException;
import com.example.tripvision.member.application.MemberSearchService;
import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.member.dto.MemberDto;
import com.example.tripvision.member.mapper.MemberHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberRepository memberRepository;

	private final MemberSearchService memberSearchService;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<MemberDto> getCurrentUser(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Member member = memberRepository.findById(userPrincipal.getId())
			.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
		return new ResponseEntity<>(MemberHelper.toDto(member),HttpStatus.OK);
	}

	// Collection get
	// 필터링, 오더링, 검색
	@GetMapping("/members")
	public ResponseEntity<List<Member>> getMemberList() {
		List<Member> memberList = memberSearchService.getMemberList();
		return new ResponseEntity<>(memberList, HttpStatus.CREATED);
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
















