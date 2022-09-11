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
@Table(name = "team", schema = "public")
public class TeamEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "team_id", updatable = false, nullable = false)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_name")
    private String name;


    @OneToMany(mappedBy = "team")
//    @JoinColumn(name = "team_id") не нужен!!! ПАША, НЕ НУЖЕН!!!
    private List<UserEntity> players;


}
