package com.mateam.application.domain.match;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
public class Match {
    private String matchName;
    private Date matchDate;
    private int matchNum;
}
