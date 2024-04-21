package com.mateam.application.adapter.in.controller.team;

import com.mateam.application.biz.team.port.in.TeamInPort;
import com.mateam.application.domain.team.TeamRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/team")
public class TeamController {

    private final TeamInPort teamInport;

    //팀 생성
    @PostMapping("/createTeam")
    public ResponseEntity createTeam(@RequestBody TeamRequest teamRequest) {

        try {
            teamInport.createTeam(teamRequest);
            return ResponseEntity.ok("Team Created successfully!");

        } catch (Exception e) {
            String errorMessage = "Failed to create team: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }


}
