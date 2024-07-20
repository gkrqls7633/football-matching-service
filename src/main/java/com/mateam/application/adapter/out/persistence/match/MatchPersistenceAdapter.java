package com.mateam.application.adapter.out.persistence.match;

import com.mateam.application.adapter.out.persistence.match.entity.MatchApplyEntity;
import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.biz.match.port.out.MatchOutPort;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@RequiredArgsConstructor
@Component
public class MatchPersistenceAdapter implements MatchOutPort {

    private final ReadMatchRepository readMatchRepository;
    private final WriteMatchRepository writeMatchRepository;
    @Override
    public String selectMatch() {

        return readMatchRepository.selectMatch();
    }

    @Override
    public List<Map<String, Object>> selectMatchList(Integer teamsize) {
        List<Map<String, Object>> resultList = readMatchRepository.selectMatchList(teamsize);

        return resultList;
    }

    @Override
    public String insertMatch(MatchEntity matchEntity) {
        return writeMatchRepository.insertMatch(matchEntity);
    }

    @Override
    public String updateMatch(MatchEntity matchEntity) {
        return writeMatchRepository.updateMatch(matchEntity);
    }

    @Override
    public String deleteMatch(MatchEntity matchEntity) {
        return writeMatchRepository.deleteMatch(matchEntity);
    }

    @Override
    public String applyMatch(MatchApplyEntity matchApplyEntity) {
        return writeMatchRepository.applyMatch(matchApplyEntity);
    }

    @Override
    public MatchApplyEntity selectApplyExistYsno(String applyNum) {
        return readMatchRepository.selectApplyExistYsno(applyNum);
    }

    @Override
    public Map<String, Object> selectApplyNum(String matchNum) {
        return readMatchRepository.selectApplyNum(matchNum);
    }

    @Override
    public String updateMatchApplyNum(Map<String, Object> updateApplyNumParam) {
        return writeMatchRepository.updateMatchApplyNum(updateApplyNumParam);
    }

}
