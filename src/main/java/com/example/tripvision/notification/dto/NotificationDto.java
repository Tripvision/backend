package com.example.tripvision.notification.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.member.dto.MemberDto;
import com.example.tripvision.notification.domain.Notification;
import com.example.tripvision.team.domain.Team;
import com.example.tripvision.team.dto.TeamDto;

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
public class NotificationDto {

	private Long id;

	@NotNull
	private String title;

	private LocalDateTime dueDate;

	private MemberDto memberDto;

	private TeamDto teamDto;

	public Notification toEntity() {
		if (id == null) {
			return Notification.builder()

				.build();
		} else {
			return Notification.builder()
				.id(id)
				.build();
		}

	}

}
