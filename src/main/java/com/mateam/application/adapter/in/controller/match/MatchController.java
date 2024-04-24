package com.mateam.application.adapter.in.controller.match;

import com.mateam.application.biz.match.port.in.MatchInPort;
import com.mateam.application.domain.match.MatchApplyRequest;
import com.mateam.application.domain.match.MatchApproveRequest;
import com.mateam.application.domain.match.MatchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/match")
@Controller
@Log4j2
public class MatchController {

    private final MatchInPort matchInPort;

    //매치 화면 조회
    @GetMapping("/main")
    public String matchHome(@RequestParam(name="teamsize", required = false) Integer teamsize, Model model) {

        model.addAttribute("teamsize", teamsize);

        return "/match/matchMain";
    }

    @ResponseBody
    @GetMapping("/")
    public String selectMatch() {
        return matchInPort.selectMatch();
    }

    //매치 조회
    @ResponseBody
    @GetMapping("/selectMatch")
    public ResponseEntity selectMatchList(@RequestParam(name="teamsize", required = false) Integer teamsize) {

        List<Map<String, Object>> res;
        if (teamsize != null) {
            res = matchInPort.selectMatchList(teamsize);
        } else {
            res = matchInPort.selectMatchList(teamsize);  //teamSize null값 전달
        }
        return ResponseEntity.ok(res);

    }

    //매치 생성
    @PostMapping("/insertMatch")
    public ResponseEntity<String> insertMatch(@RequestBody MatchRequest matchRequest) {
        try {
            matchInPort.insertMatch(matchRequest);
            return ResponseEntity.ok("Match inserted successfully!");

        } catch (Exception e) {
            String errorMessage = "Failed to insert match: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }

    //매치 상세 조회
    @PostMapping("/selectDetailMatch")
    public ResponseEntity<String> selectDetailMatch(@RequestBody MatchRequest matchRequest){
        return ResponseEntity.ok("Match selectDetailMatch successfully!");
    }


    // 매치 정보 변경
    @PutMapping("/updateMatch")
    public ResponseEntity<String> updateMatch(@RequestBody MatchRequest matchRequest){
        return ResponseEntity.ok("Match updated successfully!");
    }

    // 매치 요청(신청)
    @PostMapping("/applyMatch")
    public ResponseEntity<String> applyMatch(@RequestBody MatchApplyRequest matchApplyRequest){
        return ResponseEntity.ok("Match applied successfully!");
    }

    // 매치 승인
    @PostMapping("/approveMatch")
    public ResponseEntity<String> approveMatch(@RequestBody MatchApproveRequest matchApproveRequest){
        return ResponseEntity.ok("Match approved successfully!");
    }
}
