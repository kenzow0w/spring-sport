package org.sport.foot.dao;

import org.sport.foot.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, UUID> {
}