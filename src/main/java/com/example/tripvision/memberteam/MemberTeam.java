package com.example.tripvision.memberteam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.team.domain.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_team")
public class MemberTeam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_TEAM_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public void setMember(Member member) {
		// if(member.getTeamList().contains(this)) {
		// 	member.getTeamList().remove((this));
		// }
		this.member = member;
	}

	public void setTeam(Team team) {
		// if(team.getMemberList().contains(this)) {
		// 	team.getMemberList().remove((this));
		// }
		this.team = team;
	}
}
