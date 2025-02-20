package org.example;

import org.example.bean.*;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();

//        SpringBean springBean  = context.getBean(SpringBean.class);
//        springBean.sayHello();

//        TestBean1 testBean1 = (TestBean1) context.getBean("myconnection");
//        System.out.println(testBean1);

//        TestBean2 testBean2 = context.getBean("testBean2", TestBean2.class);
//        System.out.println(testBean2);

//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            public void run() {
//                System.out.println("Shutting down...");
//                context.close();
//            }
//        });

//        Object testBean3 = context.getBean("getConnection");
//        System.out.println(testBean3);

        TestBean1 ref1 = context.getBean(TestBean1.class);
        System.out.println(ref1);

        TestBean2 ref2 = context.getBean(TestBean2.class);
        System.out.println(ref2);

        TestBean3 ref3 = context.getBean(TestBean3.class);
        System.out.println(ref3);

        MyConnection ref4 = context.getBean(MyConnection.class);
        System.out.println(ref4);

        MyConnection ref5 = context.getBean(MyConnection.class);
        System.out.println(ref5);

        context.registerShutdownHook();
    }
}