package com.mateam.application.biz.team.port.out;

import com.mateam.application.adapter.out.persistence.team.Entity.TeamEntity;

public interface TeamOutPort {
    String createTeam(TeamEntity teamEntity);
}
