package com.example.tripvision.member.dao;

import static com.example.tripvision.member.domain.MemberBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.tripvision.member.domain.Member;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	void save() {
		// given
		String email = "ehdqn119@gmail.com";
		String name = "Lee Sang Min";

		// when
		final Member newMember = memberRepository.save(createMember(email, name));

		// then
		assertEquals(newMember.getEmail(), email);
	}

}
