package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsul8003Main {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8003Main.class,args);
    }
}
