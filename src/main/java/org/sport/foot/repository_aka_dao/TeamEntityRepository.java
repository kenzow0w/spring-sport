package org.sport.foot.repository_aka_dao;

import org.sport.foot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamEntityRepository extends JpaRepository<TeamEntity, UUID> {
    TeamEntity findByName(String name);
}
