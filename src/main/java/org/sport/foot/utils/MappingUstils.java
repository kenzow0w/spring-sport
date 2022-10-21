package org.sport.foot.utils;


import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.entity.TeamEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MappingUstils {

    public PlayerEntityDto mapToPlayerDto(PlayerEntity entity) {
        PlayerEntityDto dto = new PlayerEntityDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setTeam(entity.getTeam());
        dto.setRole(entity.getRole());
        dto.setPosition(entity.getPosition());
        dto.setRaiting(entity.getRaiting());
        return dto;
    }

    public PlayerEntity mapToPlayerEntity(PlayerEntityDto dto) {
        PlayerEntity entity = new PlayerEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setTeam(dto.getTeam());
        entity.setRole(dto.getRole());
        entity.setPosition(dto.getPosition());
        entity.setRaiting(dto.getRaiting());

        return entity;
    }

    public TeamEntityDto mapToTeamDto(TeamEntity entity) {
        TeamEntityDto dto = new TeamEntityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPlayers(entity.getPlayers().stream()
                .map(this::mapToPlayerDto)
                .collect(Collectors.toList()));
        return dto;
    }

    public TeamEntity mapToTeamEntity(TeamEntityDto dto) {
        TeamEntity entity = new TeamEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPlayers(dto.getPlayers().stream()
                .map(this::mapToPlayerEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    public RoleEntityDto mapToRoleDto(RoleEntity entity) {
        RoleEntityDto dto = new RoleEntityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public RoleEntity mapToRoleEntity(RoleEntityDto dto) {
        RoleEntity entity = new RoleEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    public PositionEntityDto mapToPositionDto(PositionEntity entity) {
        PositionEntityDto dto = new PositionEntityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public PositionEntity mapToPositionEntity(PositionEntityDto dto) {
        PositionEntity entity = new PositionEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }


}
