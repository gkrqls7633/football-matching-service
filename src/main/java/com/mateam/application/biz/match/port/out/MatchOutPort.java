package com.mateam.application.biz.match.port.out;

import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.domain.match.Match;
import com.mateam.application.domain.match.MatchRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MatchOutPort {
    public String selectMatch();

    List<Map<String, Object>> selectMatchList();

    String insertMatch(MatchEntity matchEntity);
}
