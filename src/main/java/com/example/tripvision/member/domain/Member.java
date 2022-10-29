// package com.example.tripvision.member.domain;
//
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.PrePersist;
//
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
//
// @Entity
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// public class Member {
//
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	@Column(name = "member_id")
// 	private Long id;
// 	@Column(name = "member_name")
// 	private String name;
// 	@Column(name = "member_email")
// 	private String email;
// 	@Column(name = "member_picture")
// 	private String picture;
// 	@Column(name = "member_email_verified")
// 	private Boolean emailVerified;
// 	@Column(name = "member_is_pushed")
// 	private Boolean isPushed;
// 	@Enumerated(EnumType.STRING)
// 	@Column(name = "member_provider")
// 	private AuthProvider provider;
// 	@Enumerated(EnumType.STRING)
// 	@Column(name = "member_role")
// 	private Role role;
// 	@Column(name = "member_nick_name")
// 	private String nickName;
// 	@Column(name = "member_refresh_token")
// 	private String refreshToken;
//
// 	@PrePersist
// 	public void prePersist() {
// 		this.nickName = this.nickName == null ? this.email : this.nickName;
// 		this.role = Role.ADMIN;
// 	}
//
// 	public Member update(String name, String picture) {
// 		this.name = name;
// 		this.picture = picture;
// 		return this;
// 	}
//
// 	// @checkstyle:off
// 	@Override
// 	public String toString() {
// 		return "Member{"
// 			+ "id=" + id +
// 			", name='" + name + '\'' +
// 			", email='" + email + '\'' +
// 			", picture='" + picture + '\'' +
// 			", emailVerified=" + emailVerified +
// 			", isPushed=" + isPushed +
// 			", provider=" + provider +
// 			", role=" + role +
// 			", nickName='" + nickName + '\'' +
// 			", refreshToken='" + refreshToken + '\'' +
// 			'}';
// 	}
// }
