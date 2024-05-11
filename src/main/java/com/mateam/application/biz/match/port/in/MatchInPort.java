package com.mateam.application.biz.match.port.in;

import com.mateam.application.domain.match.MatchRequest;

import java.util.List;
import java.util.Map;

public interface MatchInPort {
    String selectMatch();

    List<Map<String, Object>> selectMatchList(Integer teamsize);

    String insertMatch(MatchRequest matchRequest);

    String updateMatch(MatchRequest matchRequest);
}
