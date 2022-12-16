package com.example.tripvision.global.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripvision.global.config.security.member.UserPrincipal;
import com.example.tripvision.global.exception.ResourceNotFoundException;
import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MemberRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email)
		throws UsernameNotFoundException {
		Member user = userRepository.findByEmail(email)
			.orElseThrow(() ->
				new UsernameNotFoundException("User not found with email : " + email)
			);

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		Member user = userRepository.findById(id).orElseThrow(
			() -> new ResourceNotFoundException("User", "id", id)
		);

		return UserPrincipal.create(user);
	}
}
