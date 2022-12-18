package com.example.tripvision.dto;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tripvision.budget.dto.BudgetDto;
import com.example.tripvision.file.dto.FileDto;
import com.example.tripvision.member.domain.Member;
import com.example.tripvision.member.dto.MemberDto;
import com.example.tripvision.memberteam.MemberTeam;
import com.example.tripvision.memberteam.MemberTeamDto;
import com.example.tripvision.notification.dto.NotificationDto;
import com.example.tripvision.project.dto.ProjectDto;
import com.example.tripvision.setting.dto.SettingDto;
import com.example.tripvision.task.dto.TaskDto;
import com.example.tripvision.team.dto.TeamDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
class ProjectDtoTest {

	@DisplayName("JSON 타입으로 변환된 결과를 보여줍니다.")
	@Test
	public void toJsonFile() throws IOException {

		MemberDto memberDepDto = MemberDto
			.builder()
			.id(1L)
			.build();

		TeamDto teamDepDto = TeamDto.builder()
			.id(1L)
			.build();

		ProjectDto projectDepDto = ProjectDto.builder()
			.id(1L)
			.title("My Project Title")
			.dueDate(LocalDate.now())
			.build();

		ObjectMapper mapper = JsonMapper.builder()
			.addModule(new JavaTimeModule())
			.build();

		MemberDto memberDto = MemberDto.builder()
			.registrationDate(LocalDate.now())
			.name("Lee Sang Min")
			.email("ehdqn119@gmail.com")
			.avatarUrl("asdasda@gaaads>")
			.build();

		TeamDto teamDto1 = TeamDto.builder()
			.title("My Project Team")
			.build();

		ProjectDto projectDto = ProjectDto.builder()
			.title("My Project Title")
			.teamDto(teamDepDto)
			.dueDate(LocalDate.now())
			.build();

		Member member = Member.builder()
			.id(1L)
			.build();

		MemberTeam memberTeam = MemberTeam.builder()
			.team(teamDepDto.toEntity())
			.member(member)
			.build();

		TaskDto taskDto = TaskDto.builder()
			.projectDto(projectDepDto)
			.memberDto(memberDto)
			.comment("very good boy")
			.status("in Prgoress")
			.content("Annotation Processor is not working with lombok and querydsl, map-struct")
			.tags("bugs")
			.title("My Task Title")
			.build();

		SettingDto.SettingAndProjectDto settingDto = SettingDto.SettingAndProjectDto.builder()
			.title("Project Setting")
			.projectDto(projectDepDto)
			.build();

		NotificationDto memberNotificationDto = NotificationDto.builder()
			.title("Bugs")
			.dueDate(LocalDateTime.now())
			.memberDto(memberDepDto)
			.build();

		NotificationDto teamNotificationDto = NotificationDto.builder()
			.title("Bugs")

			.dueDate(LocalDateTime.now())
			.teamDto(teamDepDto)
			.build();

		FileDto.FileAndProjectDto fileDto = FileDto.FileAndProjectDto.builder()
			.projectDto(projectDepDto)
			.build();

		BudgetDto budgetDto = BudgetDto.builder()
//			.projectDto(projectDepDto)
			.dueDate(LocalDateTime.now())
			.build();

		MemberTeamDto memberTeamDto = MemberTeamDto.builder()
			.memberId(1L)
			.teamId(1L)
			.build();

		String result = mapper.writeValueAsString(projectDto);

		mapper.writeValue(Paths.get("./json/memberDto.json").toFile(), memberDto);
		mapper.writeValue(Paths.get("./json/projectDto.json").toFile(), projectDto);
		mapper.writeValue(Paths.get("./json/taskDto.json").toFile(), taskDto);
		mapper.writeValue(Paths.get("./json/budgetDto.json").toFile(), budgetDto);
		mapper.writeValue(Paths.get("./json/settingDto.json").toFile(), settingDto);
		mapper.writeValue(Paths.get("./json/memberNotificationDto.json").toFile(), memberNotificationDto);
		mapper.writeValue(Paths.get("./json/teamNotificationDto.json").toFile(), teamNotificationDto);
		mapper.writeValue(Paths.get("./json/fileDto.json").toFile(), fileDto);
		mapper.writeValue(Paths.get("./json/memberTeam.json").toFile(), memberTeam);
		mapper.writeValue(Paths.get("./json/team.json").toFile(), teamDto1);
		mapper.writeValue(Paths.get("./json/memberTeamDto.json").toFile(), memberTeamDto);

	}
}
