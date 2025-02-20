package org.example.config;

import org.example.bean.SpringBean;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackageClasses = SpringBean.class)
//@ImportResource("classpath:abc.xml")
//if not
//@ImportResource("file:absolute-path-of-abc.xml")
@Import({AppConfig1.class})
public class AppConfig {
    @Bean
    public SpringBean getSpringBean(){
        return new SpringBean();
    }

}
