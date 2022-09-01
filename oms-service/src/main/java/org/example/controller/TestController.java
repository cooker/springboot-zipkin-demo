package org.example.controller;

import brave.propagation.TraceContext;
import brave.propagation.TraceIdContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zipkin2.internal.Trace;

import java.util.concurrent.ExecutorService;

/**
 * 1/9/2022 12:15 下午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping
    public String get() {
        log.info("sasa");
        return "ok";
    }

    @Autowired
    Tracer tracer;
    @Autowired
    private ExecutorService executorService;

    @Async
    @GetMapping("/async")
    public String async() {
        log.info("异步操作");
        return "ok";
    }

    @GetMapping("/asyncSubmit")
    public String asyncSubmit() {
        log.info("异步操作");
        executorService.submit(()->{
            log.info("进入异步线程");
        });
        return "ok";
    }

    @GetMapping("/log")
    public String logInfo(){
        log.info("撒撒撒 {}", tracer.currentSpan().context().traceId());
        Span span = tracer.nextSpan();
        Span start = span.start();
        log.info("sasasa");
        start.end();
        return "ok";
    }
}
