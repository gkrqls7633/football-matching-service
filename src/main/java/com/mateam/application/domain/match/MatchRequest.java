package com.mateam.application.domain.match;

import com.mateam.application.domain.common.commonDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 인수로 받는 생성자 생성
public class MatchRequest extends commonDomain {

    private String matchNum;
    private String matchDate;   //매치 날짜
    private String stadiumNum;  //경기장 num
    private int matchPersonCnt; //매칭인원수(팀 당) ex) 5:5이면 matchPersonCnt는 5
    private int matchTime;      //경기소요시간


}
