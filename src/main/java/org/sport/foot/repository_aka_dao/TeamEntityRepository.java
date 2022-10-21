package org.sport.foot.repository_aka_dao;

import org.sport.foot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamEntityRepository extends JpaRepository<TeamEntity, UUID> {
//    @Query(value = "", nativeQuery = true) //TODO почитать про query на hql и sql

    TeamEntity findByName(String name);
}
