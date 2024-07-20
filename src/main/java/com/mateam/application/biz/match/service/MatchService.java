package com.mateam.application.biz.match.service;

import com.mateam.application.adapter.out.persistence.match.entity.MatchApplyEntity;
import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.biz.match.port.in.MatchInPort;
import com.mateam.application.biz.match.port.out.MatchOutPort;
import com.mateam.application.domain.match.MatchApplyRequest;
import com.mateam.application.domain.match.MatchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MatchService implements MatchInPort {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MatchOutPort matchOutPort;

    public MatchService(MatchOutPort matchOutPort) {
        this.matchOutPort = matchOutPort;
    }

    @Override
    public String selectMatch() {
        return matchOutPort.selectMatch();
    }

    @Override
    public List<Map<String, Object>> selectMatchList(Integer teamsize) {

        return matchOutPort.selectMatchList(teamsize);
    }

    @Override
    public String insertMatch(MatchRequest matchRequest) {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_string = dateFormat.format(now);

        MatchEntity matchEntity = MatchEntity.builder()
                .matchDate(date_string) //
                .stadiumNum(matchRequest.getStadiumNum())
                .matchPersonCnt(matchRequest.getMatchPersonCnt())
                .matchTime(matchRequest.getMatchTime())
                .build();

        return matchOutPort.insertMatch(matchEntity);
    }

    @Override
    public String updateMatch(MatchRequest matchRequest) {

        logger.info("############### 변경 날짜 : {} ############# ", matchRequest.getMatchDate());
        logger.info("############### 변경 시간 : {} ############# ", matchRequest.getMatchTime());
        logger.info("############### 변경 경기장 : {} ############# ", matchRequest.getStadiumNum());
        logger.info("############### 변경 인원 : {} ############# ", matchRequest.getMatchPersonCnt());


        MatchEntity matchEntity = MatchEntity.builder()
                .matchNum(matchRequest.getMatchNum())
                .matchDate(matchRequest.getMatchDate())
                .matchTime(matchRequest.getMatchTime())
                .stadiumNum(matchRequest.getStadiumNum())
                .matchPersonCnt(matchRequest.getMatchPersonCnt())
                .build();

        return matchOutPort.updateMatch(matchEntity);
    }

    @Override
    public String deleteMatch(MatchRequest matchRequest) {

        MatchEntity matchEntity = MatchEntity.builder()
                .matchNum(matchRequest.getMatchNum())
                .build();

        return matchOutPort.deleteMatch(matchEntity);
    }

    @Override
    public String applyMatch(MatchApplyRequest matchApplyRequest) {

        String matchNum = matchApplyRequest.getMatchNum();

        /**
         * 해당 matchNum의 apply_num 여부 조회
         * - match에 apply_num 없으면(최초 신청) apply_num 시퀀스 생성
         * - apply_num 있으면 해당 apply_num 리턴
         * applt_num 없었던 경우엔 해당 match_num 데이터에 반환된 apply_num update
        */
//        String applyNum = matchOutPort.selectApplyNum(matchNum);
        Map<String, Object> applyInfo = matchOutPort.selectApplyNum(matchNum);
        for(Map.Entry<String, Object> entry : applyInfo.entrySet()) {
            System.out.println(entry.getValue());
        }

        String applyNum = (String) applyInfo.get("applynum");
        // apply_num이 원래 있던 값인지, 신규인지 여부
        String applyNumExitYsno = (String) applyInfo.get("applynumexitysno");

        Map<String, Object> updateApplyNumParam = new HashMap<>();
        updateApplyNumParam.put("applyNum", applyNum);
        updateApplyNumParam.put("matchNum", matchNum);

        if ("N".equals(applyNumExitYsno)) {
            matchOutPort.updateMatchApplyNum(updateApplyNumParam);
        }
        
        /** 해당 매치의 신청기록 확인
         * - match_apply 테이블에 해당 apply_num 데이터 존재 여부 확인
         * - 데이터 없으면 최초 순번으로 insert (lastApplySrnb = 1)
         * - 데이터 있으면 마지막 순번 조회 (max_apply_srnb) -> lastApplySrnb + 1
         */
        MatchApplyEntity applyMasterEntity = matchOutPort.selectApplyExistYsno(applyNum);

        int lastApplySrnb;
        // 기존 매칭순번이 존재하는 경우
        if ("Y".equals(applyMasterEntity.getApplyExistYsno())) {
            lastApplySrnb = applyMasterEntity.getMaxApplySrnb();
            lastApplySrnb += 1;  // 다음 순번으로 신청

        // 기존 매칭순번이 없는 경우(최초등록)
        }else {
            lastApplySrnb = 1;
        }

        //승인 시간 -> 현재 시간
        Date now = new Date();
        Timestamp applyTime = new Timestamp(now.getTime());

        //화면에서 받아온 정보들
        MatchApplyEntity matchApplyEntity = MatchApplyEntity.builder()
                .applyYsno("Y") //matchApplyRequest.getApplyYsno() 승인 이니까 Y로 고정
                .applyTime(applyTime)
                .applyExistYsno(applyMasterEntity.getApplyExistYsno()) // 기존 apply seq 존재 여부
                .applySrnb(lastApplySrnb)
                .crtrId(matchApplyRequest.getCrtrId())
                .amnrId(matchApplyRequest.getAmnrId())
                .build();

        return matchOutPort.applyMatch(matchApplyEntity);
    }
}
