package com.example.tripvision.member.dao;

import java.util.List;

import com.example.tripvision.counter.dto.CountRequest;

public interface MemberRepositoryCustom {
	public List<CountRequest> countDependices(List<CountRequest> countList);
}
