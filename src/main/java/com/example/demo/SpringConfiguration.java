package com.example.demo;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;

public class SpringConfiguration {
    @Bean
    TimedAspect timedAspect(MeterRegistry reg) {
        return new TimedAspect(reg);
    }
}
