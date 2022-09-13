package org.sport.foot.controller;

import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.entity.TeamEntity;
import org.sport.foot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<TeamEntityDto> findById(@RequestBody UUID id) {
        return ResponseEntity.ok(teamService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamEntityDto>> findAll() {
        return ResponseEntity.ok(teamService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        teamService.delete(id);
        return ResponseEntity.ok("Команда успешно удалена");
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamEntityDto> update(@PathVariable UUID id, @RequestBody TeamEntity teamEntity) {
        return ResponseEntity.ok(teamService.update(id, teamEntity));
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        teamService.deleteAll();
        return ResponseEntity.ok("Список команд очищен");
    }


}
