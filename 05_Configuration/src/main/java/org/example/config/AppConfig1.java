package org.example.config;

import org.example.bean.SpringBean;
import org.example.bean.SpringBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
    @Bean
    public SpringBean1 getSpringBean1(){
        return new SpringBean1();
    }
}
