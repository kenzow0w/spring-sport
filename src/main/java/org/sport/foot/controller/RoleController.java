package org.sport.foot.controller;


import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.exceptions.EntityAlreadyExistException;
import org.sport.foot.exceptions.EntityNotFoundException;
import org.sport.foot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<RoleEntityDto> findById(@RequestParam UUID id) throws EntityNotFoundException {
        if (roleService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Роль не существует");
        }
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoleEntity> save(@RequestBody RoleEntity roleEntity) {
        if (roleService.findByName(roleEntity.getName()) != null) {
            if (roleService.findByName(roleEntity.getName()).getName().equals(roleEntity.getName())) {
                throw new EntityAlreadyExistException("Роль уже существует");
            }
        }
        return ResponseEntity.ok(roleService.save(roleEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) throws EntityNotFoundException {
        if (roleService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Роль не существует");
        }
        roleService.deleteById(id);
        return ResponseEntity.ok("Роль удалена");
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        roleService.deleteAll();
        return ResponseEntity.ok("Список ролей очищены");
    }


    @PutMapping("/{id}")
    public ResponseEntity<RoleEntityDto> update(@PathVariable UUID id, @RequestBody RoleEntity roleEntity)
            throws EntityNotFoundException {
        if (roleService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Роль не существует");
        }
        return ResponseEntity.ok(roleService.update(id, roleEntity));
    }


}
