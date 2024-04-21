package com.mateam.application.domain.team;

import com.mateam.application.domain.common.commonDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 인수로 받는 생성자 생성
public class TeamRequest extends commonDomain {

    private String teamName;      //팀명
    private String prefRegion;    //선호 지역
    private String teamMakeDate;  //default now()
    private int mtcCnt;        //매치 수 default 0

}
