package org.example.config;

import org.springframework.cloud.sleuth.zipkin2.ZipkinAutoConfiguration;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.codec.Encoding;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.Sender;

import java.util.List;

/**
 * 2/9/2022 11:50 上午
 * 描述：
 *
 * @author grant
 */
@Configuration
public class TraceSendConfig {

    @Bean(ZipkinAutoConfiguration.REPORTER_BEAN_NAME)
    public Reporter<Span> myReporter() {
        return AsyncReporter.create(myRestTemplateSender());
    }

    @Bean(ZipkinAutoConfiguration.SENDER_BEAN_NAME)
    public Sender myRestTemplateSender() {
        return new Sender() {
            @Override
            public Encoding encoding() {
                return Encoding.JSON;
            }

            @Override
            public int messageMaxBytes() {
                return Integer.MAX_VALUE;
            }

            @Override
            public int messageSizeInBytes(List<byte[]> list) {
                return encoding().listSizeInBytes(list);
            }

            @Override
            public Call<Void> sendSpans(List<byte[]> list) {
                return new TraceNoCall();
            }
        };
    }
}
