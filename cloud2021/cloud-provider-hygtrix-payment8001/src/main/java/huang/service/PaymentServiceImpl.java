package huang.service;

import com.huang.aaa.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import huang.dao.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;





    @Override
    public Payment getPaymentById(int id) {
        return paymentMapper.queryPayById(id);
    }

    @Override
    public int add(Payment payment) {
        return paymentMapper.addPay(payment);
    }
    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeoutFallback" ,commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id)
    {
        try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): 3";
    }

    @Override
    @HystrixCommand(fallbackMethod = "circleBreakFallback" ,commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value="3000"),
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String circleBreakTest(Integer id) {
        if(id < 0){
            throw new RuntimeException("ERR,ID不能小于0");
        }
        return "id为："+ id;
    }

    @Override
    public String timeoutFallback(Integer id){
        return "8005 繁忙";
    }

    @Override
    public String circleBreakFallback(Integer id) {
        return "请确认输入哦";
    }
}
