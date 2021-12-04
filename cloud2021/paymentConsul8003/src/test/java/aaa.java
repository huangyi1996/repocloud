import com.huang.aaa.Payment;
import com.huang.dao.PaymentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class aaa {
    @Autowired
    private PaymentMapper paymentMapper;
    @Test
    public void t1(){
        System.out.println(paymentMapper.getPaymentById(1).getDetail());
    }

}
