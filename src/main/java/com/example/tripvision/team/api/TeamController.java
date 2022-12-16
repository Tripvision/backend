package com.example.tripvision.team.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripvision.team.application.TeamService;
import com.example.tripvision.team.domain.Team;
import com.example.tripvision.team.dto.TeamDto;
import com.example.tripvision.team.mapper.TeamHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
public class TeamController {
	/**
	 * Collection : GET, POST, DELETE
	 * DOCUMENT : GET, UPDATE, DELETE
	 * Collection update, Document POST is not Supported.
	 * DELETE Return No Content.
	 * Client Server 에서 No content status Code 로 확인해서 성공 유무를 확인합시다.
	 * @Author Lee Sang Min
	 */
	private final TeamService teamService;

	@GetMapping("/teams")
	public ResponseEntity<Page<TeamDto>> findAllTeam(Pageable pageable) {
		final Page<Team> teamList = teamService.findAll(pageable);
		final List<TeamDto> teamList1 = teamList.stream().map(team -> TeamHelper.toDto(team)).collect(Collectors.toList());
		return new ResponseEntity<>(new PageImpl<>(teamList1), HttpStatus.OK);
	}

	@DeleteMapping("/teams")
	public ResponseEntity deleteAllTeam() {
		teamService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/teams/{id}")
	public ResponseEntity<TeamDto> findTeam(@Valid @PathVariable("id") @Min(1) Long teamId) {
		final Team team = teamService.findTeam(teamId);
		return new ResponseEntity<>(TeamHelper.toDto(team),HttpStatus.OK);
	}

	@PostMapping("/teams")
	public ResponseEntity<TeamDto> saveTeam(@RequestBody TeamDto teamDto) {
		final Team team = teamService.saveTeam(teamDto.toEntity());
		return new ResponseEntity<>(TeamHelper.toDto(team),HttpStatus.CREATED);
	}

	@PutMapping("/teams")
	public ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto teamDto) {
		log.info(teamDto.toString());
		final Team team = teamService.updateTeam(teamDto.toEntity());
		return new ResponseEntity<>(TeamHelper.toDto(team),HttpStatus.CREATED);
	}

	@DeleteMapping("/teams/{id}")
	public ResponseEntity deleteTeam(@Valid @PathVariable("id")@Min(1) Long id) {
		teamService.deleteTeam(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
