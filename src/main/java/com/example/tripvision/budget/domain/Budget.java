package com.example.tripvision.budget.domain;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budget")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "budget_id")
	private Long id;


	@OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
	private Set<Notification> notification = new LinkedHashSet<>();

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

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	public void update(Budget budget) {
		this.allow = budget.allow;
		this.notes = budget.notes;
		this.value = budget.value;
		this.notification = budget.notification;
		this.usage = budget.usage;
		this.member = budget.member;
		this.project = budget.getProject();
	}

	public void saveProject(Project project) {
		this.project = project;
	}

	public void saveMember(Member member) {
		this.member = member;
	}

}
