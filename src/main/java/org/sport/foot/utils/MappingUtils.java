package org.sport.foot.utils;


import lombok.AllArgsConstructor;
import org.sport.foot.dao.PositionEntityRepository;
import org.sport.foot.dao.RoleEntityRepository;
import org.sport.foot.dao.TeamEntityRepository;
import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.entity.TeamEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MappingUtils {
    private TeamEntityRepository teamEntityRepository;
    private RoleEntityRepository roleEntityRepository;
    private PositionEntityRepository positionEntityRepository;

    public PlayerEntityDto mapToPlayerDto(PlayerEntity entity) {
        PlayerEntityDto dto = new PlayerEntityDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setSecondName(entity.getSecondName());
        dto.setEmail(entity.getEmail());
        TeamEntity team = entity.getTeam();
        if(team != null) {
            dto.setTeamId(team.getId());
            dto.setTeamName(team.getName());
        }
        RoleEntity role = entity.getRole();
        if(role != null) {
            dto.setRoleId(role.getId());
            dto.setRoleName(role.getName());
        }
        PositionEntity position = entity.getPosition();
        if(position != null) {
            dto.setPositionId(position.getId());
            dto.setPositionName(position.getName());
        }
        dto.setRating(entity.getRating());
        return dto;
    }

    public PlayerEntity mapToPlayerEntity(PlayerEntityDto dto) {
        PlayerEntity entity = new PlayerEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSecondName(dto.getSecondName());
        entity.setEmail(dto.getEmail());
        UUID teamId = dto.getTeamId();
        entity.setRating(dto.getRating());
        if(teamId != null) {
            entity.setTeam(teamEntityRepository.findById(teamId).orElseThrow(EntityNotFoundException::new));
        }
        UUID roleId = dto.getRoleId();
        if (roleId != null) {
            entity.setRole(roleEntityRepository.findById(roleId).orElseThrow(EntityNotFoundException::new));
        }
        UUID positionId = dto.getPositionId();
        if(positionId != null) {
            entity.setPosition(positionEntityRepository.findById(positionId).orElseThrow(EntityNotFoundException::new));
        }
        return entity;
    }

    public TeamEntityDto mapToTeamDto(TeamEntity entity) {
        TeamEntityDto dto = new TeamEntityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public TeamEntity mapToTeamEntity(TeamEntityDto dto) {
        TeamEntity entity = new TeamEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
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
