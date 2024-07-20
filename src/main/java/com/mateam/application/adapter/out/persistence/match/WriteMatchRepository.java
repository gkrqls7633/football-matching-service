package com.mateam.application.adapter.out.persistence.match;

import com.mateam.application.adapter.out.persistence.match.entity.MatchApplyEntity;
import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.config.annotation.WriteDatabase;

import java.util.Map;

@WriteDatabase
public interface WriteMatchRepository {

    String insertMatch(MatchEntity matchEntity);

    String updateMatch(MatchEntity matchEntity);

    String deleteMatch(MatchEntity matchEntity);

    String applyMatch(MatchApplyEntity matchApplyEntity);

    String updateMatchApplyNum(Map<String, Object> updateApplyNumParam);
}
