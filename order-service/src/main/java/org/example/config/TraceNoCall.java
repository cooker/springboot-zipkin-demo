package org.example.config;

import lombok.extern.slf4j.Slf4j;
import zipkin2.Call;
import zipkin2.Callback;

import java.io.IOException;

/**
 * 2/9/2022 12:00 下午
 * 描述：
 *
 * @author grant
 */
@Slf4j
public class TraceNoCall extends Call.Base<Void>{
    protected Void doExecute() throws IOException {
        log.info("不上报 ...");
        return null;
    }

    protected void doEnqueue(Callback<Void> callback) {

    }

    public Call<Void> clone() {
        return new TraceNoCall();
    }
}
