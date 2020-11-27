package com.byb.springcloud.controller;


import com.byb.springcloud.entities.CommonResult;
import com.byb.springcloud.entities.Payment;
import com.byb.springcloud.service.PaymentFeignService;
import feign.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OpenfeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.paymentById(id);
    }
}
