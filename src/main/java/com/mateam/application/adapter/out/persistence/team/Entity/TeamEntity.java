package com.mateam.application.adapter.out.persistence.team.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamEntity {

    private String teamName;      //팀명
    private String prefRegion;    //선호 지역
    private String teamMakeDate;  //default now()
    private int mtcCnt;        //매치 수 default 0
}
