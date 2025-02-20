package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.di")
public class AppConfig {
//    @Bean
//    public SpringBean getSpringBean() {
//        return new SpringBean();
//    }
}
