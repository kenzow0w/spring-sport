package org.sport.foot.controller;

import lombok.AllArgsConstructor;
import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/team")
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamEntityDto>> get() {
        return ResponseEntity.ok(teamService.get());
    }

    @PostMapping
    public void save(@RequestBody TeamEntityDto dto) {
        teamService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        teamService.delete(id);
    }

}
