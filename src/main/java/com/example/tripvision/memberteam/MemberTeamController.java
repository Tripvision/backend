package com.example.tripvision.memberteam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.team.dao.TeamRepository;
import com.example.tripvision.team.domain.Team;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
public class MemberTeamController {

	private final MemberTeamRepository memberTeamRepository;
	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	@PostMapping(value = "/relations")
	public ResponseEntity saveRelation(@RequestBody MemberTeamDto memberTeamDto) {
		Member member = memberRepository.findById(memberTeamDto.getMemberId()).get();
		Team team = teamRepository.findById(memberTeamDto.getTeamId()).get();

		MemberTeam memberTeam = MemberTeam.builder()
			.team(team)
			.member(member)
			.build();

		MemberTeam memberTeam1 = memberTeamRepository.save(memberTeam);
		return new ResponseEntity(MemberTeamHelper.toDto(memberTeam1),HttpStatus.CREATED);
	}

}
