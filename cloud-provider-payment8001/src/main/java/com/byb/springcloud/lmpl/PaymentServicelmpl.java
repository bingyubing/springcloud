package com.byb.springcloud.lmpl;

import com.byb.springcloud.dao.PaymentDao;
import com.byb.springcloud.entities.Payment;
import com.byb.springcloud.serviec.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServicelmpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    public int save(Payment payment){
        return paymentDao.save(payment);
    }

    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }
}
