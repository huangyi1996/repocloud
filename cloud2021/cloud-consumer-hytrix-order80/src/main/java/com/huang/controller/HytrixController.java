package com.huang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@DefaultProperties(defaultFallback = "timeoutFallback")
public class HytrixController {
    @Autowired
    private Consum   consum;


    @ResponseBody
    @GetMapping("/order/ok/{id}")
    public String ok(@PathVariable("id")  int  id){
        return consum.ok(id);
    }

    @ResponseBody
    @HystrixCommand(fallbackMethod = "timeoutFallback" ,commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })
    @GetMapping("/order/timeout/{id}")
    public String timeout(@PathVariable("id")  int  id){
        return consum.timeout(id);
    }

    public String timeoutFallback(int  id){
        return "80端口繁忙";
    }

}
