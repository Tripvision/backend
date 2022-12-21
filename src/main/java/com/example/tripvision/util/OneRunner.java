package com.example.tripvision.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.tripvision.budget.dao.BudgetRepository;
import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.dao.FileRepository;
import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.memberteam.MemberTeamRepository;
import com.example.tripvision.project.dao.ProjectRepository;
import com.example.tripvision.project.domain.Project;

import com.example.tripvision.task.dao.TaskRepository;
import com.example.tripvision.team.dao.TeamRepository;
import com.example.tripvision.team.domain.Team;

@Order(1)
@Component
public class OneRunner implements CommandLineRunner {

	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TaskRepository taskRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberTeamRepository memberTeamRepository;
	@Autowired
	BudgetRepository budgetRepository;

	@Autowired
	FileRepository fileRepository;
	@Autowired
	TeamRepository teamRepository;

	@Override
	public void run(String... args) throws Exception {

		// insert Db table
		for (int i = 0; i <= 11; i++) {

			Member member = Member.builder()
				.avatarUrl("good")
				.email("ehdqn123@gmail.com")
				.name("Lee Sang Min")
				.registrationDate(LocalDate.now())
				.build();

			Team team = Team.builder()
				.title("asd")
				.build();

			Budget sampleBudget = Budget.builder()
				.value(1000)
				.notes("good")
				.allow(true)
				.build();

			Project project = Project.builder()
				.title("My Project")
				.dueDate(LocalDate.now())
				.build();


			Budget budget = Budget.builder()
				.value(1000)
				.notes("asdsd")
				.project(project)
				.build();
			memberRepository.save(member);
			projectRepository.save(project);
			budgetRepository.save(budget);
			teamRepository.save(team);
		}
	}
}

