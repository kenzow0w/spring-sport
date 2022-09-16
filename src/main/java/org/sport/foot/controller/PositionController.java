package org.sport.foot.controller;


import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.exceptions.EntityAlreadyExistException;
import org.sport.foot.exceptions.EntityNotFoundException;
import org.sport.foot.service.MappingUstils;
import org.sport.foot.service.PositionService;
import org.sport.foot.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<PositionEntityDto>> findAll() {
        return ResponseEntity.ok(positionService.findAll());
    }

    @GetMapping
    public ResponseEntity<PositionEntityDto> findById(@RequestParam UUID id) throws EntityNotFoundException {
        if (positionService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Такой позиции не существует");
        }
        return ResponseEntity.ok(positionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PositionEntity> save(@RequestBody PositionEntity positionEntity) {
        if (positionService.findByName(positionEntity.getName()) != null) {
            if (positionService.findByName(positionEntity.getName()).getName().equals(positionEntity.getName())) {
                throw new EntityAlreadyExistException(String.format("Позиция '%s' уже существует", positionEntity.getName()));
            }
        }
        return ResponseEntity.ok(positionService.save(positionEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable UUID id) throws EntityNotFoundException {
        if (positionService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Такой позиции не существует");
        } else {
            positionService.deleteById(id);
            return ResponseEntity.ok(String.format("Позиция с id=%s успешно удалена", id));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<PositionEntityDto> update(@PathVariable UUID id, @RequestBody PositionEntity positionEntity)
            throws EntityNotFoundException {
        if (positionService.findById(id).getId() == null) {
            throw new EntityNotFoundException("Такой позиции не существует");
        } else {
            return ResponseEntity.ok(positionService.update(id, positionEntity));
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        positionService.deleteAll();
        return ResponseEntity.ok("Список позиций очищен");
    }


}
