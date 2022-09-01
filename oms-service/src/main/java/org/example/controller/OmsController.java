package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1/9/2022 1:59 下午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@RequestMapping("/oms")
@RestController
public class OmsController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getProduct")
    public String getProduct(){
        log.info("获取商品：123456");
        rabbitTemplate.convertAndSend("orderSubmit", "#", "xxx oms 商品");
        return "123456";
    }
}
