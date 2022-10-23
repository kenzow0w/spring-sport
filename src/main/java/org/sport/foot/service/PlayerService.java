package org.sport.foot.service;

import lombok.AllArgsConstructor;
import org.sport.foot.dao.PlayerEntityRepository;
import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.utils.MappingUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PlayerService {

    private PlayerEntityRepository playerEntityRepository;
    private MappingUtils mappingUtils;

    public List<PlayerEntityDto> get() {
        return playerEntityRepository.findAll().stream()
                .map(mappingUtils::mapToPlayerDto)
                .collect(Collectors.toList());
    }

    public void save(PlayerEntityDto dto) {
        PlayerEntity entity = mappingUtils.mapToPlayerEntity(dto);
        playerEntityRepository.save(entity);
    }

    public void delete(UUID id) {
        playerEntityRepository.deleteById(id);
    }
}


