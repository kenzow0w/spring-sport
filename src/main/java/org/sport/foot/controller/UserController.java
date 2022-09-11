package org.sport.foot.controller;

import org.apache.catalina.User;
import org.sport.foot.entity.UserEntity;
import org.sport.foot.exceptions.UserAlreadyExistException;
import org.sport.foot.exceptions.UserNotFoundException;
import org.sport.foot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity getOne(@RequestParam UUID id) {
        return ResponseEntity.ok(userService.getOneUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.deleteOneUser(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.updateUser(id, userEntity));
    }


}
