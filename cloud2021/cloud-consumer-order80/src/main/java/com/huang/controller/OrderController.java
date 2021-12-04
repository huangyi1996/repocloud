package com.huang.controller;

import com.huang.aaa.CommonResult;
import com.huang.aaa.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001/";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/order/query")
    private CommonResult<Payment> get(int id){
        return restTemplate.getForObject(PAYMENT_URL+"/pays?id="+id,CommonResult.class);
    }


    @RequestMapping("/order/add")
    private CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"pay/add",payment.getDetail(),CommonResult.class);
    }


}
