package org.sport.foot.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.sport.foot.dto.base.IdEntityDto;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerEntityDto extends IdEntityDto {
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
