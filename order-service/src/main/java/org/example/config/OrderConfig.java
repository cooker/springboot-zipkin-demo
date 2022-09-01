package org.example.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

/**
 * 1/9/2022 2:43 下午
 * 描述：
 *
 * @author grant
 */
@Configuration
public interface OrderConfig {

    String QUEUE = "orderSubmit";

    @Input(QUEUE)
    SubscribableChannel orderSubmitIn();
}
