package com.mateam.match;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mateam.application.adapter.in.controller.match.MatchController;
import com.mateam.application.biz.match.port.in.MatchInPort;
import com.mateam.application.domain.match.MatchApplyRequest;
import com.mateam.application.domain.match.MatchRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MatchInPort matchInPort;


//    @DisplayName("applyMatch 테스트 코드 샘플")
//    @Test
//    void applyMatchTest() throws Exception {
//        MatchApplyRequest request = new MatchApplyRequest();
//        request.setApplyTeamName("찐밥FC");
//        request.setApplyDate("2024-07-20");
//
//        when(matchInPort.applyMatch(any(MatchApplyRequest.class))).thenReturn("Match applied successfully!");
//
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/match/applyMatch")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Match applied successfully!"));
//
//        verify(matchInPort, times(1)).applyMatch(any(MatchApplyRequest.class));
//
//    }
}
