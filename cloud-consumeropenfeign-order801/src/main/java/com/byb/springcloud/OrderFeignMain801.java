package com.byb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain801 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain801.class,args);
    }
}
