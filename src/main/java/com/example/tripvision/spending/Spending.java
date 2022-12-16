package com.example.tripvision.spending;

import java.time.LocalDateTime;

import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.domain.Project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Spending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPENDING_Id")
	private Long id;

	// 양방향 매핑 할지 생각할 것
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@Column(name = "SPENDING_spendDate")
	private LocalDateTime spendDate;

	@Column(name = "SPENDING_AMOUNT")
	private Integer amount;

	@Column(name = "SPENDING_STATUS")
	private String status;


}
