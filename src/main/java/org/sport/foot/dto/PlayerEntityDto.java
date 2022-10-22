package org.sport.foot.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.entity.TeamEntity;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerEntityDto {

    UUID id;
    String email;
    String name;
    TeamEntity team;
    RoleEntity role;
    PositionEntity position;
    Integer raiting;

}
