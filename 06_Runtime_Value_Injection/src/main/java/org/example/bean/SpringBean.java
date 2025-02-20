package org.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("Vagi - the babi")
    private String name;

    public SpringBean() {
        System.out.println("SpringBean Default Constructor");
        System.out.println("name: "+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("name: " + name);
    }

//    @Autowired(required = false)
//    public SpringBean(@Value("Shima❤️✨") String name,@Value("01") int id,@Value("She Sayed yes") String note ,@Value("yes") boolean answer) {
//        System.out.println("SpringBean Constructor");
//        System.out.println("id: "+id);
//        System.out.println("name: "+name);
//        System.out.println("answer: "+note+" ");
//        System.out.println("type: " + answer);
//    }
//
//    @Autowired(required = false)
//    public SpringBean(@Value("Shima❤️✨") String name,@Value("02") String id,@Value("She Sayed yes") String note ,@Value("yes") boolean answer) {
//        System.out.println("SpringBean Constructor");
//        System.out.println("id: "+id);
//        System.out.println("name: "+name);
//        System.out.println("answer: "+note+" ");
//        System.out.println("type: " + answer);
//    }


}
