package com.huang.service;

import com.huang.aaa.Payment;
import com.huang.dao.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;





    @Override
    public Payment getPaymentById(int id) {
        return paymentMapper.queryPayById(id);
    }

    @Override
    public int add(Payment payment) {
        return paymentMapper.addPay(payment);
    }
}
