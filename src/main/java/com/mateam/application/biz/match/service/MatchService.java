package com.mateam.application.biz.match.service;

import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.biz.match.port.in.MatchInPort;
import com.mateam.application.biz.match.port.out.MatchOutPort;
import com.mateam.application.domain.match.MatchApplyRequest;
import com.mateam.application.domain.match.MatchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MatchService implements MatchInPort {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MatchOutPort matchOutPort;

    public MatchService(MatchOutPort matchOutPort) {
        this.matchOutPort = matchOutPort;
    }

    @Override
    public String selectMatch() {
        return matchOutPort.selectMatch();
    }

    @Override
    public List<Map<String, Object>> selectMatchList(Integer teamsize) {

        return matchOutPort.selectMatchList(teamsize);
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

    @Override
    public String updateMatch(MatchRequest matchRequest) {

        logger.info("############### 변경 날짜 : {} ############# ", matchRequest.getMatchDate());
        logger.info("############### 변경 시간 : {} ############# ", matchRequest.getMatchTime());
        logger.info("############### 변경 경기장 : {} ############# ", matchRequest.getStadiumNum());
        logger.info("############### 변경 인원 : {} ############# ", matchRequest.getMatchPersonCnt());


        MatchEntity matchEntity = MatchEntity.builder()
                .matchNum(matchRequest.getMatchNum())
                .matchDate(matchRequest.getMatchDate())
                .matchTime(matchRequest.getMatchTime())
                .stadiumNum(matchRequest.getStadiumNum())
                .matchPersonCnt(matchRequest.getMatchPersonCnt())
                .build();

        return matchOutPort.updateMatch(matchEntity);
    }

    @Override
    public String applyMatch(MatchApplyRequest matchApplyRequest) {
        return "Match applied successfully!";
    }
}
