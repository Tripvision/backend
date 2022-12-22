package com.example.tripvision.team.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.team.domain.Team;

import java.util.Optional;

public interface TeamRepositoryCustom {

	Page<Team> search(Pageable pageable, String title);

	Optional<Team> findTeamLazy(Long id);

}
