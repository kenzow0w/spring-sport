package org.sport.foot.dto;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TeamEntityDto {

    private UUID id;
    private String name;
    private List<PlayerEntityDto> players;

}
