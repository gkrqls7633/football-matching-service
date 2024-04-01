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

        Date now = new Date(); // 현재 날짜와 시간을 가져오는 Date 객체 생성
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 포맷 설정
        String date_string = dateFormat.format(now); // 현재 날짜와 시간을 지정된 포맷의 문자열로 변환


        MatchEntity matchEntity = MatchEntity.builder() // MatchEntity 객체의 빌더 생성
                .matchDate(date_string) // 현재 날짜와 시간을 설정
                .matchCplYsno(matchRequest.getMatchCplYsno())
                .startYsno(matchRequest.getStartYsno())
                .stadiumNum(matchRequest.getStadiumNum())
                .build(); // MatchEntity 객체 생성 및 반환

        return matchOutPort.insertMatch(matchEntity);
    }
}
