package com.byb.springcloud.controller;

import com.byb.springcloud.entities.CommonResult;
import com.byb.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;
import java.awt.*;

@RestController//@RestController  可以返回多种信息 xml json 等   等于@Controller与 @RequestBody
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/PaymentById/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/discovery")
    public CommonResult<Payment> getserver(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery", CommonResult.class);
    }
}
