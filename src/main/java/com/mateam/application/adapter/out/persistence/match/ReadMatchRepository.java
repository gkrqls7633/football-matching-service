package com.mateam.application.adapter.out.persistence.match;

import com.mateam.application.adapter.out.persistence.match.entity.MatchApplyEntity;
import com.mateam.application.domain.match.Match;
import com.mateam.application.domain.match.MatchRequest;
import com.mateam.config.annotation.ReadDatabase;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@ReadDatabase
public interface ReadMatchRepository {
    String selectMatch();

    List<Map<String, Object>> selectMatchList(Integer teamsize);

    MatchApplyEntity selectApplyExistYsno(String applyNum);

    Map<String, Object> selectApplyNum(String matchNum);
}
