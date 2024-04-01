package com.mateam.application.domain.common;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class commonDomain {

    private String crtrId;
    private String cretDttm;
    private String amnrId;
    private String amndDttm;
    private String dltYsno;

    public commonDomain(String crtrId, String cretDttm, String amnrId, String amndDttm, String dltYsno) {
        this.crtrId = crtrId;
        this.cretDttm = cretDttm;
        this.amnrId = amnrId;
        this.amndDttm = amndDttm;
        this.dltYsno = dltYsno;
    }
}
