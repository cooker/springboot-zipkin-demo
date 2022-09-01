package org.example.mq;

import lombok.extern.slf4j.Slf4j;
import org.example.config.OrderConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 1/9/2022 2:50 下午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@Component
public class OrderSubmitListener {

    @StreamListener(OrderConfig.QUEUE)
    public void submitOrder(@Payload String jsonBody){
        log.info("订单成功：{}", jsonBody);
    }
}
