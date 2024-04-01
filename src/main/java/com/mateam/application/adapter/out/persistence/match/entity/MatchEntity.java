package com.mateam.application.adapter.out.persistence.match.entity;

import com.mateam.application.domain.common.commonDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 인수로 받는 생성자 생성
public class MatchEntity extends commonDomain {

    private String matchNum;    //경기 num
    private String matchDate;  //매치 날짜
    private String matchCplYsno;  //매치 성사 여부
    private String startYsno;  //매치 시작 여부
    private String stadiumNum; //경기장 num




}
