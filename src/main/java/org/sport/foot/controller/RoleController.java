package org.sport.foot.controller;


import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller("/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleEntityDto>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping
    public ResponseEntity<RoleEntityDto> findById(@RequestParam UUID id) {

        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoleEntity> save(@RequestBody RoleEntity roleEntity) {
        return ResponseEntity.ok(roleService.save(roleEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        roleService.deleteById(id);
        return ResponseEntity.ok("Роль удалена");
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll(){
        roleService.deleteAll();
        return ResponseEntity.ok("Список ролей очищены");
    }


    @PutMapping("/{id}")
    public ResponseEntity<RoleEntityDto> update(@PathVariable UUID id, @RequestBody RoleEntity roleEntity) {
        return ResponseEntity.ok(roleService.update(id, roleEntity));
    }

}
