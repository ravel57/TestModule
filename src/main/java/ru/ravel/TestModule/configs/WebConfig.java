package ru.ravel.TestModule.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

@Configuration
public class WebConfig {

    @Bean
    public HttpMessageConverter oxmHttpMessageConverter() {
        return new Jaxb2RootElementHttpMessageConverter();
    }

}
