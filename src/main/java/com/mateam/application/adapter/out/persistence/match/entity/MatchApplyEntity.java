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
public class MatchApplyEntity extends commonDomain {

    private String applyNum;
    private int applySrnb;
    private String applyYsno;
    private Date applyTime;

    //기존 매치 신청 여부 확인용
    private String applyExistYsno; //매칭 기존 존재 여부
    private int maxApplySrnb;      //해당 매칭num 마지막 순번

    private String crtrId;
    private String amnrId;
}
