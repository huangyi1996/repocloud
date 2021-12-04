package huang.controller;

import com.huang.aaa.CommonResult;
import com.huang.aaa.Payment;
import huang.service.PaymentServiceImpl;
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
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        System.out.println("result->"+result);
        return result;
    }
    @ResponseBody
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfo_TimeOut(id);
        System.out.println("result->"+result);
        return result;
    }




    @ResponseBody
    @RequestMapping("/pays")
    public CommonResult<Payment> res(int id){
        System.out.println("8001");
        return new CommonResult<Payment>(200,"查询成功ser"+port,paymentService.getPaymentById(id));
    }
    @ResponseBody
    @GetMapping("/paysFegin/{id}")
    public CommonResult<Payment> res1(@PathVariable("id") int id){
        System.out.println("8001");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    @ResponseBody
    @RequestMapping("/pay/circle")
    public String circle(int id){
        return paymentService.circleBreakTest(id);
    }
}
