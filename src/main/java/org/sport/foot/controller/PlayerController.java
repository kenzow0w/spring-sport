package org.sport.foot.controller;

import lombok.AllArgsConstructor;
import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerEntityDto>> get() {
        return ResponseEntity.ok(playerService.get());
    }

    @PostMapping
    public void save(@RequestBody PlayerEntityDto dto) {
        playerService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        playerService.delete(id);
    }
}
