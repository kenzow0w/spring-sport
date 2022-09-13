package org.sport.foot.service;


import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.repository_aka_dao.PositionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PositionService {


    PositionEntityRepository positionEntityRepository;

    MappingUstils mappingUstils;

    @Autowired
    public void setMappingUstils(MappingUstils mappingUstils) {
        this.mappingUstils = mappingUstils;
    }

    @Autowired
    public void setPositionEntityRepository(PositionEntityRepository positionEntityRepository) {
        this.positionEntityRepository = positionEntityRepository;
    }

    public List<PositionEntityDto> findAll() {
        return positionEntityRepository.findAll().stream()
                .map(mappingUstils::mapToPositionDto)
                .collect(Collectors.toList());
    }


    public PositionEntityDto findById(UUID id) {
        return mappingUstils.mapToPositionDto(positionEntityRepository.findById(id).orElse(new PositionEntity()));
    }

    public PositionEntity save(PositionEntity positionEntity) {
        return positionEntityRepository.save(positionEntity);
    }

    public void deleteById(UUID id) {
        positionEntityRepository.deleteById(id);
    }

    public PositionEntityDto update(UUID id, PositionEntity newEntity) {
        PositionEntity updatePosition = positionEntityRepository.findById(id).get();
        updatePosition.setName(newEntity.getName());

        return mappingUstils.mapToPositionDto(updatePosition);

    }

    public void deleteAll() {
        positionEntityRepository.deleteAll();
    }
}
