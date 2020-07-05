package com.chaos.valoraservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ValoraServiceController {
    
    @GetMapping("")
    public @ResponseBody String index() {
        log.info("Yo madafaka");
        return "Yo madafaka";
    }
    
}
