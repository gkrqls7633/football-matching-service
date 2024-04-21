package com.mateam.application.adapter.out.persistence.team;

import com.mateam.application.adapter.out.persistence.team.Entity.TeamEntity;
import com.mateam.config.annotation.WriteDatabase;

@WriteDatabase
public interface WriteTeamRepository {
    String createTeam(TeamEntity teamEntity);
}
