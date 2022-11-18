package org.sport.foot.service;

import lombok.AllArgsConstructor;
import org.sport.foot.dao.TeamEntityRepository;
import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.request.TeamRequest;
import org.sport.foot.entity.TeamEntity;
import org.sport.foot.utils.MappingUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class TeamService {

    TeamEntityRepository teamEntityRepository;
    MappingUtils mappingUtils;

    //Todo разделить на пагинированный и нет ответ
    public Page<TeamEntityDto> get(TeamRequest pageable) {
        Page<TeamEntity> page = teamEntityRepository.findAll(pageable);
        return new PageImpl<>(page.get()
                .map(mappingUtils::mapToTeamDto)
                .collect(Collectors.toList()),
                pageable, page.getTotalElements()
        );
    }

    public void save(TeamEntityDto dto) {
        Specification<TeamEntity> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getId() != null) {
                predicates.add(cb.notEqual(root.get("id"), dto.getId()));
            }
            predicates.add(cb.equal(root.get("name"), dto.getName()));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        if (teamEntityRepository.findOne(specification).isPresent()) {
            throw new EntityExistsException("Такая сущность уже есть");
        }
        TeamEntity entity = mappingUtils.mapToTeamEntity(dto);
        teamEntityRepository.save(entity);
    }

    public void delete(UUID id) {
        teamEntityRepository.deleteById(id);
    }
}
