package com.example.tripvision.member.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.BatchSize;

import com.example.tripvision.activity.TeamActivity;
import com.example.tripvision.memberteam.MemberTeam;
import com.example.tripvision.task.domain.Task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	@Column(name = "member_name")
	private String name;
	@Column(name = "member_email")
	private String email;
	@Column(name = "member_picture")
	private String picture;

	@Column(name = "member_password")
	private String password;
	@Column(name = "member_email_verified")
	private Boolean emailVerified;
	@Column(name = "member_is_pushed")
	private Boolean isPushed;
	@Enumerated(EnumType.STRING)
	@Column(name = "member_provider")
	private AuthProvider provider;

	@Column(name = "member_nick_name")
	private String nickName;
	@Column(name = "member_refresh_token")
	private String refreshToken;

	@Column(name = "member_avatar_url")
	private String avatarUrl;

	@Column(name = "member_provider_id")
	private String providerId;

	@Column(name = "member_registration_date")
	private LocalDate registrationDate;

	@ManyToOne
	@JoinColumn(name = "team_activity_id")
	private TeamActivity teamActivity;

	@BatchSize(size = 500)
	@OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
	private List<Task> taskList = new ArrayList<>();

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "team")
	@BatchSize(size = 500)
	private List<MemberTeam> teamList = new ArrayList<>();


	public Member() {

	}

	public Member update(String name, String picture) {
		this.name = name;
		this.picture = picture;
		return this;
	}

	// @checkstyle:off
	@Override
	public String toString() {
		return "Member{"
			+ "id=" + id +
			", name='" + name + '\'' +
			", email='" + email + '\'' +
			", picture='" + picture + '\'' +
			", emailVerified=" + emailVerified +
			", isPushed=" + isPushed +
			", provider=" + provider +
			", nickName='" + nickName + '\'' +
			", refreshToken='" + refreshToken + '\'' +
			'}';
	}
}
