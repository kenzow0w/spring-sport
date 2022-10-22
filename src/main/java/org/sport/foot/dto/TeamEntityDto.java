package org.sport.foot.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TeamEntityDto {

    UUID id;
    String name;
    List<PlayerEntityDto> players;

}
