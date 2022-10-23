package org.sport.foot.service;

import lombok.AllArgsConstructor;
import org.sport.foot.dao.RoleEntityRepository;
import org.sport.foot.dto.RoleEntityDto;
import org.sport.foot.entity.RoleEntity;
import org.sport.foot.utils.MappingUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RoleService {

    RoleEntityRepository roleEntityRepository;
    MappingUtils mappingUtils;

    public List<RoleEntityDto> get() {
        return roleEntityRepository.findAll().stream()
                .map(mappingUtils::mapToRoleDto)
                .collect(Collectors.toList());
    }

    public void save(RoleEntityDto dto) {
        RoleEntity entity = mappingUtils.mapToRoleEntity(dto);
        roleEntityRepository.save(entity);
    }

    public void delete(UUID id) {
        roleEntityRepository.deleteById(id);
    }
}
