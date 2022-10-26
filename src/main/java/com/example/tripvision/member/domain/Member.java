package com.example.tripvision.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.example.tripvision.global.domain.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String picture;
	@Column
	private Boolean emailVerified;
	@Column
	private Boolean isPushed;
	@Enumerated(EnumType.STRING)
	@Column
	private AuthProvider provider;
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	@Column
	private String nickName;
	@Column
	private String refreshToken;

	@PrePersist
	public void prePersist() {
		this.nickName = this.nickName == null ? this.email : this.nickName;
		this.role = Role.ADMIN;
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
			", role=" + role +
			", nickName='" + nickName + '\'' +
			", refreshToken='" + refreshToken + '\'' +
			'}';
	}
}
