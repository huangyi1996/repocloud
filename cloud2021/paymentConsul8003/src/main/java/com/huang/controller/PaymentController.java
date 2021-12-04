package com.huang.controller;

import com.huang.aaa.Payment;
import com.huang.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService  paymentService;


    @RequestMapping("/payment/{id}")
    public Payment getPaymentById(@PathVariable int id){
        return paymentService.getPaymentById(id);
    }
}
