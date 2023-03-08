package org.sport.foot.controller;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.request.PlayerRequest;
import org.sport.foot.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<Page<PlayerEntityDto>> get(PlayerRequest request) {
        return ResponseEntity.ok(playerService.get(request));
    }

    @PostMapping
    public void save(@RequestBody PlayerEntityDto dto) {
        playerService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        playerService.delete(id);
    }

    @SneakyThrows
    @GetMapping("/report")
    public void report(HttpServletResponse response) {
        playerService.report(response);
    }
}
