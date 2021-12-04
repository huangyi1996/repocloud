package com.huang.service;

import com.huang.aaa.Payment;

public interface PaymentService {
    Payment getPaymentById(int id);
    int add(Payment payment);
}
