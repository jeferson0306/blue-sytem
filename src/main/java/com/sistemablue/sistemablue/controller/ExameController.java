package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.service.ExameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exames")
public class ExameController {

    private final ExameService exameService;


}
