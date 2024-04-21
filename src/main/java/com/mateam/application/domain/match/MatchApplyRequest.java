package com.mateam.application.domain.match;

import com.mateam.application.domain.common.commonDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 인수로 받는 생성자 생성
public class MatchApplyRequest extends commonDomain {

    private String applyTeamName;
    private String applyTeamGrade;
    private String applyDate;
}
