package com.byb.springcloud.controller;

import com.byb.springcloud.entities.CommonResult;
import com.byb.springcloud.entities.Payment;
import com.byb.springcloud.serviec.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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
    @GetMapping(value = "/payment/discovery")
    public Object discovert(){
        List<String> servers = discoveryClient.getServices();
        for (String element : servers){
            System.out.println("*******element:"+element);
        }
        List<ServiceInstance> Instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : Instances) {
            System.out.println("*********instance:"+instance.getHost()+"\t"+ instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
