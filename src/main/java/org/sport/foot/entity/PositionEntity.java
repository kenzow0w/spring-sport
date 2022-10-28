package org.sport.foot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.sport.foot.entity.base.NameEntity;

import javax.persistence.*;

/**
 * Позиция игрока
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "position", schema = "public")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "position_id")),
        @AttributeOverride(name = "name", column = @Column(name = "position_name"))
})
public class PositionEntity extends NameEntity {
}
