package org.example.controller;

import brave.Span;
import brave.Tracer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.example.client.OmsClient;
import org.example.config.OrderConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1/9/2022 1:56 下午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OmsClient omsClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/submit")
    public String submit() {
        String product = omsClient.getProduct();
        log.info("获取到商品：{}", product);
        rabbitTemplate.convertAndSend(OrderConfig.QUEUE, "#", product);
        log.info("发生mq 成功");
        return "success";
    }

    Integer num = 0;

    @Autowired
    private Tracer tracer;

    @HystrixCommand(fallbackMethod = "hiError", threadPoolKey = "hiErrorPool")
    @GetMapping("/hystrix")
    public String hystrix() {
        Span span = tracer.nextSpan();
        try {
            span.start();
            log.info("进入熔断 {}", span.context().traceId());
        } finally {
            span.finish();
        }
        num++;
        if (num>10) {
            throw new RuntimeException("异常");
        }
        return "ok";
    }

    public String hiError() {
        Span span = tracer.nextSpan();
        try {
            span.start();
            log.info("荣断了 {}", span.context().traceId());
        } finally {
            span.finish();
        }
        return "hi,sorry,error!";
    }
}
