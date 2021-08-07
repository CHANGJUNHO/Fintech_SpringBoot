package com.example.demo.config.aop;

import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;

public class webClientConfig {
    @Configuration
    public class WebClientConfig implements WebFluxConfigurer {
        @Override
        public void configureHttpMessageCodecs(ServerCodecConfigurer configurer){
            configurer.defaultCodecs().maxInMemorySize(-1);
        }

        @Bean
        CodecCustomizer maxInMemorySizeCodecCustomizer(){
            return (configurer) -> configurer.defaultCodecs().maxInMemorySize(-1);
        }
    }
}
