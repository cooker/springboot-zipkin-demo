package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 1/9/2022 1:58 下午
 * 描述：
 *
 * @author grant
 */
@FeignClient(name = "oms-service")
public interface OmsClient {

    @GetMapping("/oms/getProduct")
    String getProduct();
}
