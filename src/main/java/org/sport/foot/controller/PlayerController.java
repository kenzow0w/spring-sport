package org.sport.foot.controller;

import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/players", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public void setUserService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void save(@RequestBody PlayerEntityDto user) {
        playerService.save(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerEntityDto>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntityDto> findById(@PathVariable UUID id) throws EntityNotFoundException {
        return ResponseEntity.ok(playerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        playerService.deleteById(id);
    }
}
