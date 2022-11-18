package org.sport.foot.service;

import lombok.AllArgsConstructor;
import org.sport.foot.dao.PositionEntityRepository;
import org.sport.foot.dto.PositionEntityDto;
import org.sport.foot.entity.PositionEntity;
import org.sport.foot.utils.MappingUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.criteria.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PositionService {

    PositionEntityRepository positionEntityRepository;
    MappingUtils mappingUtils;

    @Transactional(readOnly = true)
    public List<PositionEntityDto> get() {
        return positionEntityRepository.findAll().stream()
                .map(mappingUtils::mapToPositionDto)
                .collect(Collectors.toList());
    }

    public void save(PositionEntityDto dto) {
        Specification<PositionEntity> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getId() != null) {
                predicates.add(cb.notEqual(root.get("id"), dto.getId()));
            }
            predicates.add(cb.equal(root.get("name"), dto.getName()));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        if(positionEntityRepository.findOne(specification).isPresent()) {
            throw new EntityExistsException("Такая сущность уже есть");
        }
        PositionEntity entity = mappingUtils.mapToPositionEntity(dto);
        positionEntityRepository.save(entity);
    }

    public void delete(UUID id) {
        positionEntityRepository.deleteById(id);
    }
}
