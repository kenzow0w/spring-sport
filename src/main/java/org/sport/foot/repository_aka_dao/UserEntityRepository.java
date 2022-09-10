package org.sport.foot.repository_aka_dao;

import org.sport.foot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository <UserEntity, UUID> {

    UserEntity findByEmail(String email);
}
