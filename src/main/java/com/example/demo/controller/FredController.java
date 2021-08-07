package com.example.demo.controller;

import com.example.demo.dto.Observation;
import com.example.demo.service.FredService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/fred")
@RequiredArgsConstructor
@Slf4j
public class FredController {

    final FredService fredService;

    @GetMapping(path ="usbond10y")
    public Flux<Observation> getUsBond10y(){
        return fredService.getUsGovernmentBond10Y();
    }

    @GetMapping(path="interval", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Long> interval() {
        return Flux.interval(Duration.ofMillis(300));
    }


}
