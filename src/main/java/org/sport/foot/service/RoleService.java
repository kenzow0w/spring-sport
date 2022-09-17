package org.sport.foot.service;


import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.repository_aka_dao.RoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleService {

    RoleEntityRepository roleEntityRepository;

    MappingUtils mappingUtils;

    @Autowired
    public void setRoleEntityRepository(RoleEntityRepository roleEntityRepository) {
        this.roleEntityRepository = roleEntityRepository;
    }

    @Autowired
    public void setMappingUstils(MappingUtils mappingUtils) {
        this.mappingUtils = mappingUtils;
    }

    public List<RoleEntityDto> findAll() {
        return roleEntityRepository.findAll().stream()
                .map(mappingUtils::mapToRoleDto)
                .collect(Collectors.toList());
    }

    public RoleEntityDto findById(UUID id) {
        return mappingUtils.mapToRoleDto(roleEntityRepository.findById(id).orElse(new RoleEntity()));
    }

    public void deleteById(UUID id) {
        roleEntityRepository.deleteById(id);
    }

    public RoleEntity save(RoleEntity roleEntity) {
        return roleEntityRepository.save(roleEntity);
    }

    public RoleEntityDto update(UUID id, RoleEntity newEntity) {
        RoleEntity updateRole = roleEntityRepository.findById(id).get();

        updateRole.setName(newEntity.getName());

        return mappingUtils.mapToRoleDto(updateRole);
    }

    public void deleteAll() {
        roleEntityRepository.deleteAll();
    }

    public RoleEntityDto findByName(String name) {
        if(roleEntityRepository.findByName(name)==null){
            return null;
        }
        return mappingUtils.mapToRoleDto(roleEntityRepository.findByName(name));
    }
}
