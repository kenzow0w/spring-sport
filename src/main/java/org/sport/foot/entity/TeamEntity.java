package org.sport.foot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.sport.foot.dto.UserEntityDto;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "UUIDGenerator")
    @Column(name = "team_id", updatable = false, nullable = false)
    UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_name")
    String name;


    @Column(name = "team_players")
    List<UserEntityDto> players;


}
