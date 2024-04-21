package com.mateam.application.adapter.out.persistence.team;

import com.mateam.application.adapter.out.persistence.team.Entity.TeamEntity;
import com.mateam.application.biz.team.port.out.TeamOutPort;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@RequiredArgsConstructor
@Component
public class TeamPersistenceAdapter implements TeamOutPort {

    private final WriteTeamRepository writeTeamRepository;
    @Override
    public String createTeam(TeamEntity teamEntity) {
        return writeTeamRepository.createTeam(teamEntity);
    }
}
