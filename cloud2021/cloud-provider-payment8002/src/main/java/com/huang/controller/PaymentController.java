package com.huang.controller;

import com.huang.aaa.CommonResult;
import com.huang.aaa.Payment;
import com.huang.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {


    @Autowired
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String port;




    @ResponseBody
    @RequestMapping("/pays")
    public CommonResult<Payment> res(int id){
        System.out.println("8002");
        return new CommonResult<Payment>(200,"查询成功,ser"+port,paymentService.getPaymentById(id));
    }
    @ResponseBody
    @GetMapping("/paysFegin/{id}")
    public CommonResult<Payment> res1(@PathVariable("id") int id){
        System.out.println("8001");
        return new CommonResult<Payment>(200,"查询成功ser"+port,paymentService.getPaymentById(id));
    }

    @ResponseBody
    @RequestMapping("/pay/add")
    public CommonResult<Payment> add(@RequestBody String detail){
        if(paymentService.add(new Payment(detail)) == 1){
            return new CommonResult<Payment>(200,"插入成功",new Payment(detail));
        }
        return new CommonResult<Payment>(4,"插入失败",new Payment(detail));
    }
}
