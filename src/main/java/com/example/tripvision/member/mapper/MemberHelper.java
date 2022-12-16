package com.example.tripvision.member.mapper;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.member.dto.MemberDto;
import com.example.tripvision.project.mapper.ProjectHelper;
import com.example.tripvision.task.domain.Task;
import com.example.tripvision.task.dto.TaskDto;

public class MemberHelper {

	public static MemberDto toDto(Member member) {
		return MemberDto.builder()
			.id(member.getId())
			.avatarUrl(member.getAvatarUrl())
			.email(member.getEmail())
			.name(member.getName())
			.registrationDate(member.getRegistrationDate())
			.build();
	}
}
