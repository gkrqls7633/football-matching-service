package com.mateam.application.biz.match.port.out;

import com.mateam.application.adapter.out.persistence.match.entity.MatchApplyEntity;
import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;

import java.util.List;
import java.util.Map;

public interface MatchOutPort {
    public String selectMatch();

    List<Map<String, Object>> selectMatchList(Integer teamsize);

    String insertMatch(MatchEntity matchEntity);

    String updateMatch(MatchEntity matchEntity);

    String deleteMatch(MatchEntity matchEntity);

    String applyMatch(MatchApplyEntity matchApplyEntity);

    MatchApplyEntity selectApplyExistYsno(String applyNum);

    Map<String, Object> selectApplyNum(String matchNum);

    String updateMatchApplyNum(Map<String, Object> updateApplyNumParam);
}
