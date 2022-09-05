package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.core.BaseController;
import org.example.core.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 5/9/2022 10:19 上午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@RequestMapping("/orderHello")
@RestController
public class OrderHelloController extends BaseController {

    @GetMapping
    public R get() {
        return R.builder().code("200").message("success").build();
    }
}
