package com.example.tripvision.file.domain;

import com.example.tripvision.activity.TeamActivity;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.util.BaseTimeEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "file")
public class File extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	private Long id;

	// Project File 1 : N 매핑
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	// Activity File 1: N 매핑
	@ManyToOne
	@JoinColumn(name = "TEAM_ACTIVITY_ID")
	private TeamActivity teamActivity;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_SIZE")
	private Integer fileSize;

	@Column(name = "FILE_UPLOADER")
	private String fileUploader;

	// CreateDateTime -> Upload Time

	public void update(File file) {
		this.id = file.id;
	}

}
