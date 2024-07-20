package com.mateam.application.domain.match;

import com.mateam.application.domain.common.commonDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchApplyRequest extends commonDomain {

    private String matchNum;
    private String applyNum;
    private int applySrnb;
    private String applyYsno;
    private String applyTime;
}
