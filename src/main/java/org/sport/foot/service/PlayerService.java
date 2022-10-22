package org.sport.foot.service;

import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.dao.PlayerEntityRepository;
import org.sport.foot.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerEntityRepository playerEntityRepository;

    private MappingUtils mappingUtils;

    @Autowired
    public void setUserEntityRepository(PlayerEntityRepository playerEntityRepository) {
        this.playerEntityRepository = playerEntityRepository;
    }

    @Autowired
    public void setMappingUstils(MappingUtils mappingUtils) {
        this.mappingUtils = mappingUtils;
    }

    public PlayerEntityDto save(PlayerEntity user) {
        return mappingUtils.mapToPlayerDto(playerEntityRepository.save(user));

    }

    @Transactional(readOnly = true)
    public List<PlayerEntityDto> findAll() {
        return playerEntityRepository.findAll().stream()
                .map(mappingUtils::mapToPlayerDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlayerEntityDto findById(UUID id) {
        return mappingUtils.mapToPlayerDto(playerEntityRepository.findById(id).orElse(new PlayerEntity()));
    }

    public void deleteById(UUID id) {
        playerEntityRepository.deleteById(id);
    }

    public PlayerEntityDto update(UUID id, PlayerEntity newEntity) {
        PlayerEntity updateEntity = playerEntityRepository.findById(id).get();

        updateEntity.setEmail(newEntity.getEmail())
                .setName(newEntity.getName())
                .setTeam(newEntity.getTeam())
                .setRole(newEntity.getRole())
                .setPosition(newEntity.getPosition())
                .setRaiting(newEntity.getRaiting());

        return mappingUtils.mapToPlayerDto(updateEntity);
    }

    public void deleteAll() {
        playerEntityRepository.deleteAll();
    }

    public PlayerEntityDto findByEmail(String email) {
        return mappingUtils.mapToPlayerDto(playerEntityRepository.findByEmail(email));

    }
}


