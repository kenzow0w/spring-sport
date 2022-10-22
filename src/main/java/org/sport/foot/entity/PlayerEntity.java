package org.sport.foot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Игрок
 */
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user", schema = "public")
public class PlayerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "user_email")
    String email;

    @Column(name = "user_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "role_id")
    RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "position_id")
    PositionEntity position;

    @Column(name = "user_raiting")
    Integer raiting;

}
