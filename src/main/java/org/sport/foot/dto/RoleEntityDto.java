package org.sport.foot.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class RoleEntityDto implements Serializable {
    private final UUID id;
    private final String name;
}
