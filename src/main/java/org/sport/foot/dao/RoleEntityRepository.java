package org.sport.foot.dao;

import org.sport.foot.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, UUID> {
    RoleEntity findByName(String name);
}