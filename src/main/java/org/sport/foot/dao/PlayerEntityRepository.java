package org.sport.foot.dao;

import org.sport.foot.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerEntityRepository extends JpaRepository <PlayerEntity, UUID> {
    PlayerEntity findByEmail(String email);
}
