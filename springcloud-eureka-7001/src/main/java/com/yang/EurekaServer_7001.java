package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TangYuan
 * @create 2021--06--09--15:24
 * @description
 */
@SpringBootApplication
@EnableEurekaServer   //服务端的启动类，可以接受注册
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class,args);
    }
}
