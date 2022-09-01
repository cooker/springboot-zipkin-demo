package org.example.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1/9/2022 12:18 下午
 * 描述：
 *
 * @author grant
 */
@Configuration
public class OmsConfig {

    /**
     * 人工异步
     * @param beanFactory
     * @return
     */
    @Bean
    public ExecutorService executorService(BeanFactory beanFactory){
        return new TraceableExecutorService(beanFactory, Executors.newCachedThreadPool());
    }

}
