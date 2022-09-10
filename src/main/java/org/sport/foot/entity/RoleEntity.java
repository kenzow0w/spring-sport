package org.sport.foot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "UUIDGenerator")
    @Column(name = "role_id", updatable = false, nullable = false)
    UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_name")
    String name;
}
