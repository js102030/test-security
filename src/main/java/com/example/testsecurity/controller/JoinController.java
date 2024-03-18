package com.example.testsecurity.controller;

import com.example.testsecurity.dto.JoinDto;
import com.example.testsecurity.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDto) {

        log.info("joinProcess 실행");

        joinService.joinUser(joinDto);

        return "redirect:/login";
    }

}
