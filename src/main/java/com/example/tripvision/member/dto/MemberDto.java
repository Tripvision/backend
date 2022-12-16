package com.example.tripvision.member.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.tripvision.activity.TeamActivity;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.team.domain.Team;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

	private Long id;

	private Team team;

	private TeamActivity teamActivity;

	@NotNull
	private String name;

	@NotNull
	private String avatarUrl;

	@Email
	private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registrationDate;



	// Registration Date => Create Date Time

	public Member toEntity() {
		if(id == null) {
			return Member.builder()
				.avatarUrl(avatarUrl)
				.build();
		}
		else {
			return Member.builder()
				.id(id)
				.avatarUrl(avatarUrl)
				.build();
		}
	}
}
