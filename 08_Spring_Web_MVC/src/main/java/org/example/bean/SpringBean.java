package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    public SpringBean() {
        System.out.println("SpringBean Constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBean Factory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name: " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBean Disposed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBean afterPropertiesSet");
    }
}
