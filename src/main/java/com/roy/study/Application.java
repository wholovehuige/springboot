package com.roy.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(Application.class);
//        Properties properties = new Properties();
//        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("application.yml");
//        properties.load(inputStream);
//        properties.setProperty("active","prd");
//        String value = properties.getProperty("active");
//        System.out.println(value);

        application.run(args);
    }
}