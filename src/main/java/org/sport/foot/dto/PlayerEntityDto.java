package org.sport.foot.dto;

import lombok.Data;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.entity.TeamEntity;

import java.util.UUID;

@Data
public class PlayerEntityDto {
    private UUID id;
    private String email;
    private String name;
    private TeamEntity team;
    private RoleEntity role;
    private PositionEntity position;
    private Integer raiting;
}
