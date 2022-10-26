package com.example.tripvision.member.application;

import java.util.List;

import com.example.tripvision.member.domain.Member;

public interface MemberSearchService {

	List<Member> getMemberList();

	Member getMember(Long memberId);

}
