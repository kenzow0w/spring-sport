package org.sport.foot.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerEntityDto {

    UUID id;
    String firstName;
    String lastName;
    String secondName;
    String email;
    UUID teamId;
    String teamName;
    UUID roleId;
    String roleName;
    UUID positionId;
    String positionName;
    Integer rating;

}
