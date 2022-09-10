package org.sport.foot.dto;


import lombok.Data;

@Data
public class UserEntityDto {


    private final Long id;
    private final String email;
    private final String name;
    private final String team;
    private final String role;
    private final String position;
    private final int raiting;


}
