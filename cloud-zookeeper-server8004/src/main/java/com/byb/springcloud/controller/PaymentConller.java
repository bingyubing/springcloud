package com.byb.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

public class PaymentConller {
    @Value("${server.port}")
    private String serverport;
    @RequestMapping(value = "/payment/zk")
    public String payment(){
        return "springcloud with zookeeper:"+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
