package com.aplikacja.przyklad1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("*")); // Pozwala na połączenia z dowolnej domeny
        config.setAllowedMethods(Collections.singletonList("*")); // Pozwala na wszystkie metody (GET, POST, PUT, DELETE)
        config.setAllowedHeaders(Collections.singletonList("*")); // Pozwala na wszystkie nagłówki
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
