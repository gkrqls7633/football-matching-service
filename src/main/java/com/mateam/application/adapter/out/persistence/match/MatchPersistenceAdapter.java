package com.mateam.application.adapter.out.persistence.match;

import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.biz.match.port.out.MatchOutPort;
import com.mateam.application.domain.match.MatchRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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


}
