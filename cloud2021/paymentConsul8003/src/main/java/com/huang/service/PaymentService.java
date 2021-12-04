package com.huang.service;

import com.huang.aaa.Payment;
import com.huang.dao.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;



    public Payment getPaymentById(int id){
        return paymentMapper.getPaymentById(id);
    }
}
