package com.example.tripvision.member.application;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.member.exception.MemberNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberSearchServiceImpl implements MemberSearchService {

	private final MemberRepository memberRepository;

	@Transactional
	@Override
	public List<Member> getMemberList() {
		Optional<List<Member>> memberList = Optional.of(memberRepository.findAll());
		return memberList.orElseThrow(() -> new MemberNotFoundException("This member is not Found"));
	}

	@Transactional
	@Override
	public Member getMember(Long id) {
		Optional<Member> getMember = memberRepository.findById(id);
		return getMember.orElseThrow(() -> new MemberNotFoundException("This member is not Found"));
	}
}


