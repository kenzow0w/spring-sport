package org.sport.foot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "user", schema = "public")
public class PlayerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @Column(name = "user_raiting")
    private Integer raiting;

}
