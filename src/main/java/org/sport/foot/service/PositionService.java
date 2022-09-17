package org.sport.foot.service;


import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.repository_aka_dao.PositionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PositionService {


    PositionEntityRepository positionEntityRepository;

    MappingUtils mappingUtils;

    @Autowired
    public void setMappingUstils(MappingUtils mappingUtils) {
        this.mappingUtils = mappingUtils;
    }

    @Autowired
    public void setPositionEntityRepository(PositionEntityRepository positionEntityRepository) {
        this.positionEntityRepository = positionEntityRepository;
    }

    @Transactional(readOnly = true)
    public List<PositionEntityDto> findAll() {
        return positionEntityRepository.findAll().stream()
                .map(mappingUtils::mapToPositionDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PositionEntityDto findById(UUID id) {
        return mappingUtils.mapToPositionDto(positionEntityRepository.findById(id).orElse(new PositionEntity()));
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

        return mappingUtils.mapToPositionDto(updatePosition);

    }

    public void deleteAll() {
        positionEntityRepository.deleteAll();
    }

    public PositionEntityDto findByName(String name) {
        if (positionEntityRepository.findByName(name) == null){
            return null;
        }
            return mappingUtils.mapToPositionDto(positionEntityRepository.findByName(name));
    }
}
