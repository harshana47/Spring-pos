package org.example;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        Map<String, String> env = System.getenv();
        //print env
//        System.out.println("Environment variables:");
//        for (Map.Entry<String, String> entry : env.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

//        Properties properties = System.getProperties();
//        System.out.println(System.getProperty("os.name"));

        context.registerShutdownHook();
    }
}
