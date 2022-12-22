package com.example.tripvision.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.team.domain.Team;
import com.example.tripvision.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="project")
public class Project extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long id;
	@Column(name = "project_title")
	private String title;

	@Column(name = "project_name")
	private String name;

	@Column(name = "project_status")
	private Boolean status;

	@Column(name = "dueDate")
	private LocalDate dueDate;

	@Column(name = "project_logourl")
	private String logoUrl;

	@Column(name = "project_type")
	private String type;

	@Column(name = "project_description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "project_notification_type")
	private NotificationType notificationType;

	@OneToOne(mappedBy = "project")
	private Budget budget;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	@OneToMany(mappedBy = "project")
	private List<File> fileList = new ArrayList<>();


	// 연관관계 편의 메소드와 이유
	public void update(Project project) {
		this.id = project.id;
		this.dueDate = project.dueDate;
		this.title = project.title;
		this.name = project.name;
		this.type = project.type;
		this.description = project.description;
		this.status = project.status;
		this.notificationType = project.notificationType;
		this.team = project.team;
		this.budget = project.budget;
	}

	@Builder
	public Project(Long id, String title, String name, Boolean status, LocalDate dueDate, String logoUrl, String type, String description, NotificationType notificationType, Budget budget, Team team) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.status = status;
		this.dueDate = dueDate;
		this.logoUrl = logoUrl;
		this.type = type;
		this.description = description;
		this.notificationType = notificationType;
		this.budget = budget;
		this.team = team;
	}

	// Budget delete에서 필요해 추가
	public void updateBudget(Budget budget){
		this.budget = budget;
	}

	//Budget save시에 OneToOne 관계에서 Budget 가지고 있는지 판단
	public boolean hasBudget(){
		if (this.budget!=null) return true;
		return false;
	}
}
