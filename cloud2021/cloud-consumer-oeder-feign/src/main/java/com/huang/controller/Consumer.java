package com.huang.controller;

import com.huang.aaa.CommonResult;
import com.huang.aaa.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface Consumer {
    @GetMapping("/paysFegin/{id}")
    CommonResult<Payment> getP(@PathVariable("id") int id);

    @GetMapping("/pays")
    CommonResult<Payment> c(@RequestBody int id);

    @GetMapping("/1/1/timeout")
    String  feignTimeout();
}
