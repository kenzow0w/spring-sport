package org.sport.foot.controller;

import lombok.AllArgsConstructor;
import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/role")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleEntityDto>> get() {
        return ResponseEntity.ok(roleService.get());
    }

    @PostMapping
    public void save(@RequestBody RoleEntityDto dto) {
        roleService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        roleService.delete(id);
    }

}
