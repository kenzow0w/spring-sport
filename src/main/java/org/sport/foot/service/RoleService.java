package org.sport.foot.service;


import org.sport.foot.entity.RoleEntity;
import org.sport.foot.repository_aka_dao.RoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    RoleEntityRepository roleEntityRepository;

    @Autowired
    public void setRoleEntityRepository(RoleEntityRepository roleEntityRepository) {
        this.roleEntityRepository = roleEntityRepository;
    }

    public List<RoleEntity> getAllRoles() {
        return roleEntityRepository.findAll();
    }

    public RoleEntity getOneRole(UUID id) {
        return roleEntityRepository.findById(id).get();
    }

    public UUID deleteOneTeam(UUID id) {
        roleEntityRepository.deleteById(id);
        return id;
    }

    public RoleEntity save(RoleEntity roleEntity) {
        return roleEntityRepository.save(roleEntity);
    }

    public RoleEntity updateRole(UUID id, RoleEntity newEntity) {
        RoleEntity updateRole = roleEntityRepository.findById(id).get();

        updateRole.setName(newEntity.getName());

        return updateRole;
    }
}
