package com.byb.springcloud.service;

import com.byb.springcloud.entities.CommonResult;
import com.byb.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/PaymentById/get/{id}")
    public CommonResult<Payment> paymentById(@PathVariable long id);
}
