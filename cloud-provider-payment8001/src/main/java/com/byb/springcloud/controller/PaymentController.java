package com.byb.springcloud.controller;

import com.byb.springcloud.entities.CommonResult;
import com.byb.springcloud.entities.Payment;
import com.byb.springcloud.serviec.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.save(payment);
        if(result > 0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(404,"失败",null);
        }
    }
    @GetMapping(value = "/payment/PaymentById/get/{id}")
    public CommonResult paymentById(@PathVariable long id){
        Payment payment;
        payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(404,"没有对应记录",null);
        }
    }

}
