package com.example.tripvision.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.memberteam.MemberTeam;
import com.example.tripvision.memberteam.MemberTeamRepository;
import com.example.tripvision.team.dao.TeamRepository;
import com.example.tripvision.team.domain.Team;

@Order(3)
@Component
public class DependenciesRunner implements CommandLineRunner {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MemberTeamRepository memberTeamRepository;
	@Autowired
	TeamRepository teamRepository;

	@Override
	public void run(String... args) throws Exception {
		for (long x = 1; x <= 8; x++) {

			for (long y=1; y <= 8; y++) {

				Member member = memberRepository.findById(x).get();

				Team team = teamRepository.findById((y)).get();

				MemberTeam memberTeam1 = MemberTeam.builder()
					.member(member)
					.team(team)
					.build();
				memberTeamRepository.save(memberTeam1);
			}
		}
	}
}
