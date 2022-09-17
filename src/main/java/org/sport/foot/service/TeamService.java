package org.sport.foot.service;


import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.entity.TeamEntity;
import org.sport.foot.repository_aka_dao.TeamEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamService {

    TeamEntityRepository teamEntityRepository;

    MappingUtils mappingUtils;

    @Autowired
    public void setTeamEntityRepository(TeamEntityRepository teamEntityRepository) {
        this.teamEntityRepository = teamEntityRepository;
    }

    @Autowired
    public void setMappingUstils(MappingUtils mappingUtils) {
        this.mappingUtils = mappingUtils;
    }

    public void save(TeamEntity team) {
        teamEntityRepository.save(team);
    }

    public TeamEntityDto findById(UUID id) {
        return mappingUtils.mapToTeamDto(teamEntityRepository.findById(id).orElse(new TeamEntity()));
    }

    public List<TeamEntityDto> findAll() {
        return teamEntityRepository.findAll().stream()
                .map(mappingUtils::mapToTeamDto)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        teamEntityRepository.deleteById(id);
    }

    public TeamEntityDto update(UUID id, TeamEntity newEntity) {
        TeamEntity updateEntity = teamEntityRepository.findById(id).get();
        updateEntity.setName(newEntity.getName());
        return mappingUtils.mapToTeamDto(updateEntity);
    }

    public void deleteAll() {
        teamEntityRepository.deleteAll();
    }
}
