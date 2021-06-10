package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author TangYuan
 * @create 2021--06--09--03:19
 * @description
 */
@SpringBootApplication
@EnableEurekaClient  //在服务启动后自动注册到eureka中
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }
}
