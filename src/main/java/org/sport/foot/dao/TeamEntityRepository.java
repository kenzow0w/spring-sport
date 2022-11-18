package org.sport.foot.dao;

import org.sport.foot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamEntityRepository extends PagingAndSortingRepository<TeamEntity, UUID>, JpaSpecificationExecutor<TeamEntity> {
}
