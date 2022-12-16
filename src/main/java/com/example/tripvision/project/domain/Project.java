package com.example.tripvision.project.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;
import com.example.tripvision.util.BaseTimeEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Entity
@Table(name="project")
public class Project extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "status")
	private String status;

	@Column(name = "dueDate")
	private LocalDate dueDate;

	// Project Setting 1:1 단방향
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "setting_id")
	private Setting setting;

	// Project Budget(예산) 1:1 단방향
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "budget_id")
	private Budget budget;

	// Project Team(팀) 1:1 단방향
	// 이상할 수도 있습니다
	@OneToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "project")
	private List<File> fileList = new ArrayList<>();


	// 연관관계 편의 메소드와 이유
	public void update(Project project) {
		this.id = project.id;
		this.dueDate = project.dueDate;
		this.title = project.title;

		this.team = project.team;
		this.budget = project.budget;
		this.setting = project.setting;
		this.member = project.member;
	}
}
