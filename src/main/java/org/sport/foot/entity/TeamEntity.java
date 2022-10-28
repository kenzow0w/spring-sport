package org.sport.foot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.sport.foot.entity.base.NameEntity;

import javax.persistence.*;

/**
 * Команда
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "team", schema = "public")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "team_id")),
        @AttributeOverride(name = "name", column = @Column(name = "team_name"))
})
public class TeamEntity extends NameEntity {
}
