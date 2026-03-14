package com.support.incident_api.config;

import com.support.incident_api.entity.Status;
import com.support.incident_api.entity.Priority;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Lambda for Case-Insensitive Status Conversion
        registry.addConverter(String.class, Status.class, source -> {
            if (source == null || source.isBlank()) return null;
            try {
                return Status.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                return null; // Prevents app crash on invalid URL values
            }
        });

        // Lambda for Case-Insensitive Priority Conversion
        registry.addConverter(String.class, Priority.class, source -> {
            if (source == null || source.isBlank()) return null;
            try {
                return Priority.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        });
    }
}
