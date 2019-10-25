package org.nzy.lifeservicemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.nzy.lifeservicemanager.dao")
public class LifeServiceManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeServiceManagerApplication.class, args);
    }

}
