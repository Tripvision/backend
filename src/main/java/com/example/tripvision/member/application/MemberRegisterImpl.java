package com.example.tripvision.member.application;

import javax.transaction.Transactional;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;

import com.example.tripvision.global.exception.ErrorCode;
import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.member.exception.MemberEmailDuplicateException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberRegisterImpl implements MemberRegisterService {

	private final MemberRepository memberRepository;

	@Transactional
	@Override
	public Member registerMember(Member member) {
		duplicateMemberCheck(member.getEmail());

		return memberRepository.save(member);
	}

	@Transactional
	public void duplicateMemberCheck(String email) {
		ThreadContext.put("email", email);
		Member duplicateMember = memberRepository.findByEmail(email)
			.orElseThrow(() -> new MemberEmailDuplicateException("Duplicate Member", ErrorCode.EMAIL_DUPLICATION));
	}
}
