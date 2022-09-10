package org.sport.foot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "user_email")
    String email;

    @Column(name = "user_name")
    String name;
    
    @Column(name = "user_team")
    TeamEntity team;

    @Column(name = "user_role")
    String role;

    @Column(name = "user_position")
    String position;

    @Column(name = "user_raiting")
    Integer raiting;

}
