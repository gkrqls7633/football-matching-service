package com.mateam.application.biz.team.service;

import com.mateam.application.adapter.out.persistence.team.Entity.TeamEntity;
import com.mateam.application.biz.team.port.in.TeamInPort;
import com.mateam.application.biz.team.port.out.TeamOutPort;
import com.mateam.application.domain.team.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TeamService implements TeamInPort {

    private final TeamOutPort teamOutPort;
    @Override
    public String createTeam(TeamRequest teamRequest) {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_string = dateFormat.format(now);

        TeamEntity teamEntity = TeamEntity.builder()
                .teamName((teamRequest.getTeamName()))
                .teamMakeDate(date_string)
                .mtcCnt(0)
                .prefRegion(teamRequest.getPrefRegion())
                .build();
        return teamOutPort.createTeam(teamEntity);
    }
}
