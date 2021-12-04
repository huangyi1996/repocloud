package com.huang.controller;

import com.huang.service.PaymentServicei;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceIm implements Consumer {
    @Override
    public String ok(int id) {
        return "服务器繁忙哦------";
    }

    @Override
    public String timeout(int id) {
        return "80目前繁忙哦";
    }
}
