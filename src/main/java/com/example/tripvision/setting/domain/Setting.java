package com.example.tripvision.setting.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

import com.example.tripvision.project.domain.Project;
import com.example.tripvision.team.domain.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="setting")
public class Setting {

	// Team 에 대한 Setting 값입니다.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SETTING_ID")
	private Long id;

	@Column(name = "SETTING_LOGO")
	private String logoUrl;

	@Column(name = "SETTING_NAME")
	private String name;

	@Column(name = "SETTING_TYPE")
	private String type;

	@Column(name = "SETTING_DESCRIPTION")
	private String description;

	@Column(name = "SETTING_DUE_DATE")
	private LocalDate dueDate;

	@Column(name = "SETTING_NOTIFICATION_TYPE")
	private String notifierType;

	@Column(name = "SETTING_STATUS")
	private Boolean status;
	@OneToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	public void update(Setting setting) {
		this.id = setting.id;
		this.logoUrl = setting.logoUrl;
		this.dueDate = setting.dueDate;
		this.status = setting.status;
		this.notifierType = setting.notifierType;
		this.name = setting.name;
		this.type = setting.type;
		this.description = setting.description;
		this.project = project;
	}
}