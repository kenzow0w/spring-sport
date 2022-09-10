package org.sport.foot.service;


import org.sport.foot.entity.PositionEntity;
import org.sport.foot.repository_aka_dao.PositionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PositionService {


    PositionEntityRepository positionEntityRepository;

    @Autowired
    public void setPositionEntityRepository(PositionEntityRepository positionEntityRepository) {
        this.positionEntityRepository = positionEntityRepository;
    }

    public List<PositionEntity> getAllPositions() {
        return positionEntityRepository.findAll();
    }


    public PositionEntity getOnePosition(UUID id) {
        return positionEntityRepository.findById(id).get();
    }

    public PositionEntity save(PositionEntity positionEntity) {
        return positionEntityRepository.save(positionEntity);
    }

    public UUID deleteOnePosition(UUID id) {
        positionEntityRepository.deleteById(id);
        return id;
    }

    public PositionEntity updatePosition(UUID id, PositionEntity newEntity) {
        PositionEntity updatePosition = positionEntityRepository.findById(id).get();
        updatePosition.setName(newEntity.getName());

        return updatePosition;
    }
}
