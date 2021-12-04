package huang.service;

import com.huang.aaa.Payment;

public interface PaymentService {
    Payment getPaymentById(int id);
    int add(Payment payment);
    String paymentInfo_OK(Integer id);
    String paymentInfo_TimeOut(Integer id);
    String circleBreakTest(Integer id);
    String timeoutFallback(Integer id);
    String circleBreakFallback(Integer id);
}
