package org.sport.foot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Setter
@Getter
@Entity
public class PositionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "UUIDGenerator")
    @Column(name = "position_id", updatable = false, nullable = false)
    UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_name")
    String name;
}
