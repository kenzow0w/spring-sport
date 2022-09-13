package org.sport.foot.controller;

import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {


    private PlayerService playerService;

    @Autowired
    public void setUserService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PlayerEntity user) {
        playerService.save(user);
        return ResponseEntity.ok("Игрок успешно сохранен");
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerEntityDto>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping
    public ResponseEntity<PlayerEntityDto> findById(@RequestParam UUID id) {
        return ResponseEntity.ok(playerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable UUID id) {
        playerService.deleteById(id);
        return ResponseEntity.ok("Игрок успешно удален");

    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerEntityDto> update(@PathVariable UUID id, @RequestBody PlayerEntity playerEntity) {
        return ResponseEntity.ok(playerService.update(id, playerEntity));
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        playerService.deleteAll();
        return ResponseEntity.ok("Список игроков очищен");
    }


}
