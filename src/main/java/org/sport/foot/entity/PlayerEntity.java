package org.sport.foot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.sport.foot.entity.base.IdEntity;

import javax.persistence.*;

/**
 * Игрок
 */
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "player", schema = "public")
@AttributeOverride(name = "id", column = @Column(name = "player_id"))
public class PlayerEntity extends IdEntity {
    /**
     * Имя
     */
    @Column(name = "player_first_name")
    String firstName;
    /**
     * Фамилия
     */
    @Column(name = "player_last_name")
    String lastName;
    /**
     * Отчество
     */
    @Column(name = "player_second_name")
    String secondName;
    /**
     * Эл. почта
     */
    @Column(name = "player_email")
    String email;
    /**
     * Рейтинг
     */
    @Column(name = "player_rating")
    Integer rating;
    /**
     * Команда
     */
    @ManyToOne
    @JoinColumn(name = "team_id")
    TeamEntity team;
    /**
     * Роль игрока в команде
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    RoleEntity role;
    /**
     * Позиция игрока
     */
    @ManyToOne
    @JoinColumn(name = "position_id")
    PositionEntity position;
}
