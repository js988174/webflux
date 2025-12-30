package com.example.webflux.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/reactive")

public class ReactiveProgrammingController {

    private static final Logger logger = LoggerFactory.getLogger(ReactiveProgrammingController.class);

    @GetMapping("/onenine/flex")
    public Flux<Integer> produceOne() {
        return Flux.create(integerFluxSink -> {
            for (int i = 1; i <=9; i++) {
                try {
                    logger.info("현재 처리하고 있는 스레드 이름 : {}",
                            Thread.currentThread().getName());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    logger.error("에러 발생", e);
                }
                integerFluxSink.next(i);
            }

                integerFluxSink.complete();
            });
        }

}
