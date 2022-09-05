package org.example.handler;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.example.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 5/9/2022 10:21 上午
 * 描述：
 *
 * @author grant
 */
@Slf4j
@ControllerAdvice
public class TraceResponseHandler implements ResponseBodyAdvice {

    @Autowired
    private Tracer tracer;

    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof R) {
            ((R)body).setRequestId(tracer.currentSpan().context().traceIdString());
        }
        return body;
    }
}
