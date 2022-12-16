package com.example.tripvision.task.domain;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.domain.Project;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@Column(name = "task_tag")
	private String tags;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "comment")
	private String comment;

	@Column(name = "TASK_STATUS")
	private String status;

	public void updateTask(Task task) {
		this.project = task.project;
		this.tags = task.tags;
		this.title = task.title;
		this.content = task.content;
		this.comment = task.comment;
		this.status = task.status;
	}

	// 연관관계 저장
	public void setProject(Project project) {
		this.project = project;
	}

}
