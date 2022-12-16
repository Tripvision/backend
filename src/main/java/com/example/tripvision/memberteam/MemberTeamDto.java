package com.example.tripvision.memberteam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MemberTeamDto {
	private Long memberId;
	private Long teamId;


}
