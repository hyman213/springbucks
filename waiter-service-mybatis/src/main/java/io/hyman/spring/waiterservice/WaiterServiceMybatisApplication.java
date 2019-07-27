package io.hyman.spring.waiterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WaiterServiceMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaiterServiceMybatisApplication.class, args);
    }

}
