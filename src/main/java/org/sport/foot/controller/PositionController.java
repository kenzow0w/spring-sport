package org.sport.foot.controller;

import lombok.AllArgsConstructor;
import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/position")
@AllArgsConstructor
public class PositionController {

    PositionService positionService;

    @GetMapping
    public ResponseEntity<List<PositionEntityDto>> get() {
        return ResponseEntity.ok(positionService.get());
    }

    @PostMapping
    public void save(@RequestBody PositionEntityDto dto) {
        positionService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        positionService.delete(id);
    }
}
