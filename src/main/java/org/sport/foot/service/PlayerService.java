package org.sport.foot.service;

import lombok.AllArgsConstructor;
import org.junit.platform.commons.util.StringUtils;
import org.sport.foot.dao.PlayerEntityRepository;
import org.sport.foot.dto.PlayerEntityDto;
import org.sport.foot.entity.PlayerEntity;
import org.sport.foot.request.PlayerRequest;
import org.sport.foot.utils.MappingUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class PlayerService {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private PlayerEntityRepository playerEntityRepository;
    private MappingUtils mappingUtils;

    public Page<PlayerEntityDto> get(PlayerRequest request) {
        String selectSql = "select     pl.player_id          as id, " +
                "                      pl.player_first_name  as firstName, " +
                "                      pl.player_last_name   as lastName, " +
                "                      pl.player_second_name as secondName, " +
                "                      pl.player_email       as email, " +
                "                      pl.player_rating      as rating,  " +
                "                      t.team_id             as teamId, " +
                "                      t.team_name           as teamName, " +
                "                      r.role_id             as roleId, " +
                "                      r.role_name           as roleName, " +
                "                      p.position_id         as positionId, " +
                "                      p.position_name       as positionName ";
        String fromSql = " from public.player pl " +
                " left join public.team t on pl.team_id = t.team_id " +
                " left join public.role r on pl.role_id = r.role_id " +
                " left join public.position p on pl.position_id = p.position_id " +
                " where 1 = 1 ";
        if (StringUtils.isNotBlank(request.getFirstName())) {
            fromSql += " and pl.player_first_name ilike :firstName ";
            request.setFirstName(request.getFirstName() + "%");
        }
        if (StringUtils.isNotBlank(request.getLastName())) {
            fromSql += " and pl.player_last_name ilike :lastName ";
            request.setLastName(request.getLastName() + "%");
        }
        if (StringUtils.isNotBlank(request.getSecondName())) {
            fromSql += " and pl.player_second_name ilike :secondName ";
            request.setSecondName(request.getSecondName() + "%");
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            fromSql += " and pl.player_email ilike :email ";
            request.setEmail(request.getEmail() + "%");
        }
        if (request.getRatingFrom() != null) {
            fromSql += " and pl.player_rating >= :ratingFrom ";
        }
        if (request.getRatingTo() != null) {
            fromSql += " and pl.player_rating <= :ratingTo ";
        }
        if (request.getTeamId() != null) {
            fromSql += " and pl.team_id = :teamId ";
        }
        if (request.getRoleId() != null) {
            fromSql += " and pl.role_id = :roleId ";
        }
        if (request.getPositionId() != null) {
            fromSql += " and pl.position_id = :positionId ";
        }
        List<PlayerEntityDto> list = namedParameterJdbcTemplate.query(
                selectSql + fromSql + " offset :page * :size limit :size",
                new BeanPropertySqlParameterSource(request),
                new BeanPropertyRowMapper<>(PlayerEntityDto.class)
        );
        Long size = namedParameterJdbcTemplate.queryForObject(
                "select count(1) " + fromSql,
                new BeanPropertySqlParameterSource(request),
                Long.class
        );
        return new PageImpl<>(
                list,
                PageRequest.of(request.getPage(), request.getSize()),
                size != null ? size : 0
        );
    }

    public void save(PlayerEntityDto dto) {
        PlayerEntity entity = mappingUtils.mapToPlayerEntity(dto);
        playerEntityRepository.save(entity);
    }

    public void delete(UUID id) {
        playerEntityRepository.deleteById(id);
    }
}


