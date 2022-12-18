package com.example.tripvision.budget.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.tripvision.budget.domain.Budget;
import com.example.tripvision.budget.domain.Usage;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.project.domain.Project;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.setting.domain.Setting;
import com.example.tripvision.team.domain.Team;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class BudgetDto {

	private Long id;
	@Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDateTime dueDate;
	@NotNull
	private Usage usage;
	@NotNull
	private String notes;
	@NotNull
	private Integer value;
	@NotNull
	private Boolean allow;

	private Long projectId;

	@Builder
	private BudgetDto(Long id, LocalDateTime dueDate, Usage usage, String notes, Integer value, Boolean allow, Long projectId) {
		this.id = id;
		this.dueDate = dueDate;
		this.usage = usage;
		this.notes = notes;
		this.value = value;
		this.allow = allow;
		this.projectId = projectId;
	}

	public BudgetDto(Budget budget){
		this.id = budget.getId();
		this.dueDate = budget.getDueDate();
		this.usage = budget.getUsage();
		this.notes = budget.getNotes();
		this.value = budget.getValue();
		this.allow = budget.getAllow();
		this.projectId = budget.getProject().getId();
	}

	public Budget toEntity(Project project) {
		return Budget.builder()
			.dueDate(dueDate)
			.usage(usage)
			.notes(notes)
			.value(value)
			.allow(allow)
			.project(project)
			.build();
	}

	public Budget toEntity() {
		return Budget.builder()
			.dueDate(dueDate)
			.usage(usage)
			.notes(notes)
			.value(value)
			.allow(allow)
			.project(Project.builder().id(projectId).build())
			.build();
	}

	@Getter
	@Builder
	@AllArgsConstructor
	public static class Abc{

		private String note;
		private Integer value;

//		public Abc(Member member){
//			this.note = member.getName();
//
//		}
	}

	@Getter
	@Setter
	public static class Bbb{

		private Abc abc;

//		public Bbb(Budget budget){
//			this.abc = new Abc(budget.getMember());
//		}
	}
}
