package com.mateam.application.biz.match.service;

import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.biz.match.port.in.MatchInPort;
import com.mateam.application.biz.match.port.out.MatchOutPort;
import com.mateam.application.domain.match.Match;
import com.mateam.application.domain.match.MatchRequest;
import com.mateam.util.ResponseMessageDto;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MatchService implements MatchInPort {

    private final MatchOutPort matchOutPort;

    public MatchService(MatchOutPort matchOutPort) {
        this.matchOutPort = matchOutPort;
    }

    @Override
    public String selectMatch() {
        return matchOutPort.selectMatch();
    }

    @Override
    public List<Map<String, Object>> selectMatchList() {

        return matchOutPort.selectMatchList();
    }

    @Override
    public String insertMatch(MatchRequest matchRequest) {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_string = dateFormat.format(now);

        MatchEntity matchEntity = MatchEntity.builder()
                .matchDate(date_string) //
                .stadiumNum(matchRequest.getStadiumNum())
                .matchPersonCnt(matchRequest.getMatchPersonCnt())
                .matchTime(matchRequest.getMatchTime())
                .build();

        return matchOutPort.insertMatch(matchEntity);
    }
}
