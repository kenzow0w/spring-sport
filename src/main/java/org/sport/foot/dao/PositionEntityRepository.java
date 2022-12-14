package org.sport.foot.dao;

import org.sport.foot.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionEntityRepository extends JpaRepository <PositionEntity, UUID>, JpaSpecificationExecutor<PositionEntity> {
}
