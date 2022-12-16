package com.example.tripvision.member.domain;

public class MemberBuilder {

	public static Member build() {
		final String value = "ehdqn119@gmail.com";
		final String name = "Lee Sang Min";
		return createMember(value, name);
	}

	public static Member createMember(String email, String name) {
		return Member.builder()
			.email(email)
			.name(name)
			//.referralCode(ReferralCode.generateCode())
			.build();
	}

	// private static Name nameBuild() {
	// 	return Name.builder()
	// 		.first("first")
	// 		.middle("middle")
	// 		.last("last")
	// 		.build();
	// }

}
