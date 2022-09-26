package org.sport.foot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "role", schema = "public")
public class RoleEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "role_id", updatable = false, nullable = false)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_name")
    private String name;

}
