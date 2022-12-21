package com.example.tripvision.budget.domain;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.notification.domain.Notification;
import com.example.tripvision.project.domain.Project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "budget")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "budget_id")
	private Long id;

	@OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
	private Set<Notification> notification = new LinkedHashSet<>();

	@Column(name = "DUE_DATE")
	private LocalDateTime dueDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "BUDGET_CHARACTER")
	private Usage usage;

	@Column(name = "BUDGET_NOTES")
	private String notes;

	@Column(name = "BUDGET_VALUE")
	private Integer value;

	@Column(name = "BUDGET_ALLOW")
	private Boolean allow;

	@OneToOne(mappedBy = "budget")
	private Project project;

	//연관관계 수정
//	@ManyToOne
//	@JoinColumn(name = "MEMBER_ID")
//	private Member member;

	@Builder
	private Budget(Long id, Set<Notification> notification, LocalDateTime dueDate, Usage usage, String notes, Integer value, Boolean allow, Project project) {
		this.id = id;
		this.notification = notification;
		this.dueDate = dueDate;
		this.usage = usage;
		this.notes = notes;
		this.value = value;
		this.allow = allow;
		this.project = project;
	}

	/*
	변경 해야하는 필드만 update 메소드로 빼서 메소드 나누기
	 */
	public void update(Budget budget) {
		this.allow = budget.allow;
		this.notes = budget.notes;
		this.value = budget.value;
//		this.notification = budget.notification;
		this.usage = budget.usage;
		this.project = budget.project;
	}

	//삭제
	public void saveProject(Project project) {
		this.project = project;
	}

}
