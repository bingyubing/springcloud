package com.byb.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@Configuration用于定义配置类，可替换xml配置文件，
// 被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容
@Slf4j
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//赋予RestTemplate 负载均衡能力  ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
