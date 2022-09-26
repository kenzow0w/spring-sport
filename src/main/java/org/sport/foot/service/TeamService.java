package org.sport.foot.service;


import org.sport.foot.dto.TeamEntityDto;
import org.sport.foot.entity.TeamEntity;
import org.sport.foot.repository_aka_dao.TeamEntityRepository;
import org.sport.foot.utils.MappingUstils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamService {

    TeamEntityRepository teamEntityRepository;

    MappingUstils mappingUstils;

    //    @Qualifier //TODO читать
    @Autowired
    public void setTeamEntityRepository(TeamEntityRepository teamEntityRepository) {
        this.teamEntityRepository = teamEntityRepository;
    }

    @Autowired
    public void setMappingUstils(MappingUstils mappingUstils) {
        this.mappingUstils = mappingUstils;
    }


    @NonNull         //TODO читать и читать KeyCloak и Spring Boot, АОП
    public TeamEntity save(TeamEntity team) {
        return teamEntityRepository.save(team);
    }

    public TeamEntityDto findById(UUID id) {
        return mappingUstils.mapToTeamDto(teamEntityRepository.findById(id).orElse(new TeamEntity()));
    }

    public List<TeamEntityDto> findAll() {
        return teamEntityRepository.findAll().stream()
                .map(mappingUstils::mapToTeamDto)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        teamEntityRepository.deleteById(id);
    }

    public TeamEntityDto update(UUID id, TeamEntity newEntity) {
        TeamEntity updateEntity = teamEntityRepository.findById(id).get();
        updateEntity.setName(newEntity.getName());
        return mappingUstils.mapToTeamDto(updateEntity);
    }

    public void deleteAll() {
        teamEntityRepository.deleteAll();
    }
}
