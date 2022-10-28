package org.sport.foot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.sport.foot.entity.base.NameEntity;

import javax.persistence.*;

/**
 * Роль игрока в команде
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "role", schema = "public")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "role_id")),
        @AttributeOverride(name = "name", column = @Column(name = "role_name"))
})
public class RoleEntity extends NameEntity {
}
