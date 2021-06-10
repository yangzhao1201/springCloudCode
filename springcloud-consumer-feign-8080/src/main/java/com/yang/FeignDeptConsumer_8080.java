package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * @author TangYuan
 * @create 2021--06--09--04:05
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.yang"})
public class FeignDeptConsumer_8080 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_8080.class,args);
    }
}
