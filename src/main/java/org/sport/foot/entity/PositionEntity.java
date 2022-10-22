package org.sport.foot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Позиция игрока
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "position", schema = "public")
public class PositionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "position_id", updatable = false, nullable = false)
    UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_name")
    String name;

}
