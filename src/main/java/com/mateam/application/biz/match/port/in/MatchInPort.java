package com.mateam.application.biz.match.port.in;

import com.mateam.application.domain.match.Match;
import com.mateam.application.domain.match.MatchRequest;
import com.mateam.util.ResponseMessageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MatchInPort {
    String selectMatch();

    List<Map<String, Object>> selectMatchList();

    String insertMatch(MatchRequest matchRequest);
}
