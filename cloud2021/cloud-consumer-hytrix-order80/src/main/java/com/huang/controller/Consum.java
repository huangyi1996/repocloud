package com.huang.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface Consum {
    @GetMapping("payment/hystrix/ok/{id}")
    String ok(@PathVariable("id") int id);


    @GetMapping("payment/hystrix/timeout/{id}")
    String  timeout(@PathVariable("id") int id);

}
