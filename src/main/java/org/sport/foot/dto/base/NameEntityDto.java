package org.sport.foot.dto.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NameEntityDto extends IdEntityDto {
    String name;
}
