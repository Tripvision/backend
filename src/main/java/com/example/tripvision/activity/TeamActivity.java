package com.example.tripvision.activity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.util.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "team_activity")
public class TeamActivity extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEAM_ACTIVITY_ID")
	private Long id;

	@Column(name = "ACTIVITY_NAME")
	private String activityName;

	@Column(name = "ACTIVITY_DATE")
	private LocalDateTime activityDate;

	/**
	 * MEMBER : MEMBER_AVATAR_URL, MEMBER_NAME
	 * 1 : N  단방향 관계 매핑은 UPDATE 쿼리가 나오기 때문에 좋지않다. N : 1 양방향으로 하자.
	 */

	@OneToMany(mappedBy = "teamActivity", fetch = FetchType.LAZY)
	private Set<Member> memberList = new HashSet<>();

	/**
	 * FILE : NAME, SIZE
	 */
	@OneToMany(mappedBy = "teamActivity", fetch = FetchType.LAZY)
	private Set<File> fileList = new HashSet<>();


}
