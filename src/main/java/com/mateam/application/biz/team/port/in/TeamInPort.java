package com.mateam.application.biz.team.port.in;

import com.mateam.application.domain.team.TeamRequest;

public interface TeamInPort {
    String createTeam(TeamRequest teamRequest);
}
