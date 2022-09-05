package org.example.handler;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 5/9/2022 9:27 上午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@Component
public class TraceIdHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private Tracer tracer;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("X-B3-TraceId", tracer.currentSpan().context().traceIdString());
        return true;
    }

}
