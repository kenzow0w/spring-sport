package org.sport.foot.service;

import org.sport.foot.entity.UserEntity;
import org.sport.foot.exceptions.UserAlreadyExistException;
import org.sport.foot.exceptions.UserNotFoundException;
import org.sport.foot.repository_aka_dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserEntityRepository userEntityRepository;

    @Autowired
    public void setUserEntityRepository(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public UserEntity save(UserEntity user) {
        return userEntityRepository.save(user);

    }

    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    public UserEntity getOneUser(UUID id) {
        return userEntityRepository.findById(id).get();
    }

    public UUID deleteOneUser(UUID id) {
        userEntityRepository.deleteById(id);
        return id;
    }

    public UserEntity updateUser(UUID id, UserEntity newEntity) {
        UserEntity updateEntity = userEntityRepository.findById(id).get();

        updateEntity.setEmail(newEntity.getEmail());
        updateEntity.setName(newEntity.getName());
        updateEntity.setTeam(newEntity.getTeam());
        updateEntity.setRole(newEntity.getRole());
        updateEntity.setPosition(newEntity.getPosition());
        updateEntity.setRaiting(newEntity.getRaiting());
        return updateEntity;

    }
}
