package org.sport.foot.controller;

import lombok.AllArgsConstructor;
import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.request.TeamRequest;
import org.sport.foot.service.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/team")
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping
    public ResponseEntity<Page<TeamEntityDto>> get(TeamRequest request) {
        return ResponseEntity.ok(teamService.get(request));
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
