package org.sport.foot.repository_aka_dao;

import org.sport.foot.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerEntityRepository extends JpaRepository <PlayerEntity, UUID> {
    PlayerEntity findByEmail(String email);
}
