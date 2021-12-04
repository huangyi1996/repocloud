package com.huang.dao;

import com.huang.aaa.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper {
    Payment getPaymentById(int id);
}
