package org.example;

import org.example.config.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Hello world!
 *
 */
@EnableHystrix
@EnableBinding({OrderConfig.class})
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderApp.class, args);
    }
}
