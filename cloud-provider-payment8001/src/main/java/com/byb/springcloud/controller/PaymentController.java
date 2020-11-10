package com.byb.springcloud.controller;

import com.byb.springcloud.entities.CommonResult;
import com.byb.springcloud.entities.Payment;
import com.byb.springcloud.serviec.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverport;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.save(payment);
        if(result > 0){
            return new CommonResult(200,"插入成功port="+serverport,result);
        }else {
            return new CommonResult(404,"失败",null);
        }
    }
    @GetMapping(value = "/payment/PaymentById/get/{id}")
    public CommonResult paymentById(@PathVariable long id){
        Payment payment;
        payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功port="+serverport,payment);
        }else {
            return new CommonResult(404,"没有对应记录",null);
        }
    }
}
