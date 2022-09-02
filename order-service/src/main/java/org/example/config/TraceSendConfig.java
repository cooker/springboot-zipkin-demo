package org.example.config;

import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Call;
import zipkin2.codec.Encoding;
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
    @Bean
    public Sender myRestTemplateSender(final ZipkinProperties zipkin,
                                       ZipkinRestTemplateCustomizer zipkinRestTemplateCustomizer) {
        return new Sender() {
            @Override
            public Encoding encoding() {
                return zipkin.getEncoder().encoding();
            }

            @Override
            public int messageMaxBytes() {
                return 5 * 1024 * 1024;
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
