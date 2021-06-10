package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author TangYuan
 * @create 2021--06--10--01:16
 * @description
 */

@SpringBootApplication
@EnableHystrixDashboard  //开启监控依赖
public class DeptConsumerDashboard {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard.class,args);
    }
}
