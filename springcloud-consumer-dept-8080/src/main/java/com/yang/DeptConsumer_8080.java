package com.yang;

import com.yang.controller.DeptConsumerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author TangYuan
 * @create 2021--06--09--04:05
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_8080 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8080.class,args);
    }
}
