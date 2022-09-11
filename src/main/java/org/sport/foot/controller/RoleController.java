package org.sport.foot.controller;


import org.sport.foot.entity.RoleEntity;
import org.sport.foot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller("/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping
    public ResponseEntity getOne(@RequestParam UUID id) {

        return ResponseEntity.ok(roleService.getOneRole(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody RoleEntity roleEntity) {
        return ResponseEntity.ok(roleService.save(roleEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable UUID id) {
        return ResponseEntity.ok(roleService.deleteOneTeam(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody RoleEntity roleEntity) {
        return ResponseEntity.ok(roleService.updateRole(id, roleEntity));
    }

}
