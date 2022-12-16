package com.example.tripvision.notification.domain;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.member.domain.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTIFICATION_ID")
	private Long id;

	@Column(name = "TYPE_ID")
	@Enumerated(EnumType.STRING)
	private Type type;

	// Notification Member 1 :  N 단방향 매핑
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "BUDGET_ID")
	private Budget budget;

	public void update(Notification notification) {
		this.type = type;
	}
}
