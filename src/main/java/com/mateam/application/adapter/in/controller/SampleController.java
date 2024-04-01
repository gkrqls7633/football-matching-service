package com.mateam.application.adapter.in.controller;

import com.mateam.application.biz.sample.port.in.SampleInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/")
//@RestController
@Controller
public class SampleController {

//    @Autowired
    private final SampleInPort sampleInPort;

    @GetMapping("/")
    public String home() {
        return "index";
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
