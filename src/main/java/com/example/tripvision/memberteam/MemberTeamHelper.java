package com.example.tripvision.memberteam;

import com.example.tripvision.file.domain.File;
import com.example.tripvision.file.dto.FileDto;
import com.example.tripvision.member.domain.Member;

public class MemberTeamHelper {

	public static MemberTeamDto toDto(MemberTeam memberTeam) {
		return MemberTeamDto.builder()
			.teamId(memberTeam.getTeam().getId())
			.memberId(memberTeam.getMember().getId())
			.build();
	}
}
