package org.sport.foot.service;


import org.sport.foot.entity.TeamEntity;
import org.sport.foot.repository_aka_dao.TeamEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    TeamEntityRepository teamEntityRepository;


//    @Qualifier //TODO читать
    @Autowired
    public void setTeamEntityRepository(TeamEntityRepository teamEntityRepository) {
        this.teamEntityRepository = teamEntityRepository;
    }


    @NonNull         //TODO читать и читать KeyCloak и Spring Boot, АОП
    public TeamEntity save(TeamEntity team) {
        return teamEntityRepository.save(team);
    }

    public TeamEntity getOne(UUID id) {
        return teamEntityRepository.findById(id).get();
    }

    public List<TeamEntity> getAll() {
        return teamEntityRepository.findAll();
    }

    public UUID delete(UUID id) {
        teamEntityRepository.deleteById(id);
        return id;
    }

    public TeamEntity update(UUID id, TeamEntity newEntity) {
        TeamEntity updateEntity = teamEntityRepository.findById(id).get();
        updateEntity.setName(newEntity.getName());
        return updateEntity;
    }
}
