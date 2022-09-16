package org.sport.foot.controller;

import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.exceptions.EntityAlreadyExistException;
import org.sport.foot.exceptions.EntityNotFoundException;
import org.sport.foot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> save(@RequestBody PlayerEntity user) throws EntityAlreadyExistException{
        if(playerService.findByEmail(user.getEmail()).getEmail().equals(user.getEmail())){
            throw new EntityAlreadyExistException("Игрок с таким email уже существует");
        }
        playerService.save(user);
        return ResponseEntity.ok("Игрок успешно сохранен");
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerEntityDto>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping
    public ResponseEntity<PlayerEntityDto> findById(@RequestParam UUID id) throws EntityNotFoundException {
        if (playerService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Такого игрока не существует");
        } else {
            return ResponseEntity.ok(playerService.findById(id));
        }

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
