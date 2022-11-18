package org.sport.foot.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.sport.foot.dto.base.NameEntityDto;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamEntityDto extends NameEntityDto {
}
