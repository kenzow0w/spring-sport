package org.sport.foot.controller;

import org.sport.foot.entity.TeamEntity;
import org.sport.foot.entity.UserEntity;
import org.sport.foot.exceptions.TeamNotFoundException;
import org.sport.foot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(path = "/teams", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {

    private TeamService teamService;

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }


    @PostMapping
    public ResponseEntity<String> save(@RequestBody TeamEntity team) {
        teamService.save(team);
        return ResponseEntity.ok(String.format("Команда '%s' успешно сохранена", team));
    }

    @GetMapping
    public ResponseEntity<TeamEntity> getOneTeam(@RequestBody UUID id) {
        return ResponseEntity.ok(teamService.getOneTeam(id));
    }

    @GetMapping("/all")
    public ResponseEntity getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneTeam(@PathVariable UUID id) {
        return ResponseEntity.ok(teamService.deleteTeam(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTeam(@PathVariable UUID id, @RequestBody TeamEntity teamEntity) {
        return ResponseEntity.ok(teamService.updateTeam(id, teamEntity));
    }


}
