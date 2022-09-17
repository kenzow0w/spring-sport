package org.sport.foot.repository_aka_dao;

import org.sport.foot.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionEntityRepository extends JpaRepository <PositionEntity, UUID> {
    PositionEntity findByName(String name);
}
