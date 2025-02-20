package org.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean{
    @Value("${os.name}")
    private String osName;

    @Value("${USERNAME}")
    private String logname;

    @Value("${db.user}")
    private String DB_Username;

    @Value("${db.password}")
    private String DB_Password;

    private String dbPassword;
    public SpringBean() {
        System.out.println("SpringBean Default Constructor");;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("OS Name: " +osName);
        System.out.println("Log Name: " + logname);
        System.out.println("DB Username: " + DB_Username);
        System.out.println("DB Password: " + DB_Password);
    }
}
