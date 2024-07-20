package com.mateam.application.adapter.in.controller;

import com.mateam.application.biz.sample.port.in.SampleInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class SampleController {

//    @Autowired
    private final SampleInPort sampleInPort;

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/matchMain")
    public String matchMain(){
        return "/match/matchMain";
    }

    @ResponseBody
    @GetMapping("/sample/{dgctPtrStfSum}")
    public String selectSample(@PathVariable String dgctPtrStfSum) {

        return sampleInPort.selectSample(dgctPtrStfSum);
    }


}
