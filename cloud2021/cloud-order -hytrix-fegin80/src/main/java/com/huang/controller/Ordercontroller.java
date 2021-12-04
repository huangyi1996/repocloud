package com.huang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ordercontroller {
    @Autowired
    private Consumer consumer;


    @ResponseBody
    @GetMapping("/order/ok/{id}")
    public String ok(@PathVariable("id")  int  id){
        return consumer.ok(id);
    }

    @ResponseBody
    @GetMapping("/order/timeout/{id}")
    public String timeout(@PathVariable("id")  int  id){
        return consumer.timeout(id);
    }

    public String timeoutFallback(int  id){
        return "80端口繁忙";
    }
}
