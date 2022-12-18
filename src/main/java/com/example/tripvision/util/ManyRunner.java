package com.example.tripvision.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.tripvision.budget.dao.BudgetRepository;
import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.file.dao.FileRepository;
import com.example.tripvision.file.domain.File;
import com.example.tripvision.member.dao.MemberRepository;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.dao.ProjectRepository;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.task.dao.TaskRepository;
import com.example.tripvision.task.domain.Task;

@Order(2)
@Component
public class ManyRunner implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	FileRepository fileRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	BudgetRepository budgetRepository;

	@Override
	public void run(String... args) throws Exception {



		for (int i = 1; i <= 11; i++) {

			Member member = memberRepository.findById((long)i).get();
			Project project = projectRepository.findById((long)i).get();
			Budget budget = budgetRepository.findById((long)i).get();


				Task task = Task.builder()
					.project(project)
					.member(member)
					.status("Competed")
					.tags("bugs")
					.title("My Title")
					.build();

				File file = File.builder()
					.fileName("good")
					.fileSize(500)
					.fileUploader("da")
					.build();


				project.setBudget(budget);
				projectRepository.save(project);
				taskRepository.save(task);
				fileRepository.save(file);
				budgetRepository.save(budget);
		}
	}
}
