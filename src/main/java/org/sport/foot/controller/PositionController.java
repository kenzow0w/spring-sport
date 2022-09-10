package org.sport.foot.controller;


import org.sport.foot.entity.PositionEntity;
import org.sport.foot.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/position")
public class PositionController {


    PositionService positionService;

    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllPositions() {
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @GetMapping
    public ResponseEntity getOnePosition(@RequestParam UUID id) {
        return ResponseEntity.ok(positionService.getOnePosition(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody PositionEntity positionEntity) {
        return ResponseEntity.ok(positionService.save(positionEntity));
    }

    @DeleteMapping
    public ResponseEntity deleteOnePosition(@PathVariable UUID id) {
        return ResponseEntity.ok(positionService.deleteOnePosition(id));
    }

    @PutMapping("{/id}")
    public ResponseEntity updatePosition(@PathVariable UUID id, @RequestBody PositionEntity positionEntity) {
        return ResponseEntity.ok(positionService.updatePosition(id, positionEntity));
    }


}
