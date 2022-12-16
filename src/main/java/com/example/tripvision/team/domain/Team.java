package com.example.tripvision.team.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.memberteam.MemberTeam;
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
@Table(name="team")
public class Team extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long id;

	@OneToMany(mappedBy = "member")
	private List<MemberTeam> memberList = new ArrayList<>();

	@Column(name = "title")
	private String title;



	public void update(Team team) {
		this.id = team.id;
	}




}
