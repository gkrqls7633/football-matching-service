package com.mateam.application.adapter.in.controller.match;

import com.mateam.application.biz.match.port.in.MatchInPort;
import com.mateam.application.domain.match.MatchRequest;
import com.mateam.util.ResponseMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/match")
@Controller
@Log4j2
public class MatchController {

    private final MatchInPort matchInPort;

    @GetMapping("/main")
    public String matchHome() {
        return "/match/matchMain";
    }

    @ResponseBody
    @GetMapping("/")
    public String selectMatch() {
        return matchInPort.selectMatch();
    }

    @ResponseBody
    @GetMapping("/selectMatch")
    public List<Map<String, Object>> selectMatchList() {

//        Map<String, MatchRequest> data = (Map<String, MatchRequest>) matchInPort.selectMatchList();

        return matchInPort.selectMatchList();

    }

    @ResponseBody
    @PostMapping("/aaa")
    public ResponseMessageDto<Object> selectMessageTest() {
        return ResponseMessageDto.of("resultCode", "message", ResponseMessageDto.of("a", "b", "c"));
    }

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
}
