package org.sport.foot.controller;

import org.sport.foot.entity.TeamEntity;
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
    public ResponseEntity<TeamEntity> getOne(@RequestBody UUID id) {
        return ResponseEntity.ok(teamService.getOne(id));
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(teamService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable UUID id) {
        return ResponseEntity.ok(teamService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody TeamEntity teamEntity) {
        return ResponseEntity.ok(teamService.update(id, teamEntity));
    }


}
