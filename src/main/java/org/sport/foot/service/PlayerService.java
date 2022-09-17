package org.sport.foot.service;

import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.repository_aka_dao.PlayerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
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
    public void setMappingUtils(MappingUtils mappingUtils) {
        this.mappingUtils = mappingUtils;
    }

    public void save(PlayerEntityDto user) {
        if(findByEmail(user.getEmail()) != null){
            throw new EntityExistsException("Игрок с таким email уже существует");
        }
        PlayerEntity playerEntity = mappingUtils.mapToPlayerEntity(user);
        playerEntityRepository.save(playerEntity);
    }

    @Transactional(readOnly = true)
    public List<PlayerEntityDto> findAll() {
        return playerEntityRepository.findAll().stream()
                .map(mappingUtils::mapToPlayerDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlayerEntityDto findById(UUID id) {
        return mappingUtils.mapToPlayerDto(playerEntityRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteById(UUID id) {
        playerEntityRepository.deleteById(id);
    }

    @Transactional
    public PlayerEntityDto findByEmail(String email) {
        return mappingUtils.mapToPlayerDto(playerEntityRepository.findByEmail(email));
    }
}


