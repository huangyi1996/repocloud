package com.huang.controller;

import com.huang.aaa.CommonResult;
import com.huang.aaa.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consum {
    @Autowired
    private Consumer consumer;




    @GetMapping("/consum/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") int id){
        return consumer.getP(id);
    }
    @GetMapping("/c")
    public CommonResult<Payment>  kkk(int id){
        return consumer.getP(id);
    }
    @HystrixCommand(fallbackMethod = "timeoutFallback" ,commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value="3000")})
    @GetMapping("/consum/payment/timeout")
    public String timeout(){
        System.out.println("timeout---------------------");
        return consumer.feignTimeout();
    }

}
