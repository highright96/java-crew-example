package dev.highright96.springstudy.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRegistrationBean {

    @Bean
    public FilterRegistrationBean<CustomFilter> customFilterBean() {
        FilterRegistrationBean<CustomFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CustomFilter());
        registration.setOrder(1);
        registration.addUrlPatterns("/api/*");
        return registration;
    }
}
