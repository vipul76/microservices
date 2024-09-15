package com.ms.student_service.configuration.feignConf;

import feign.Request;
import feign.Retryer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignAddressConf {

    @Value("${address.service.url}")
    private String addressServiceUrl;

    public String getAddressServiceUrl() {
        return addressServiceUrl;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 30000); // Connect timeout 5s, Read timeout 30s
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 5000, 3); // Initial interval 1s, max interval 5s, max attempts 3
    }
}
