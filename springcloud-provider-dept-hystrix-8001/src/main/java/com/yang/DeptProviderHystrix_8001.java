package com.yang;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author TangYuan
 * @create 2021--06--09--03:19
 * @description
 */
@SpringBootApplication
@EnableEurekaClient  //在服务启动后自动注册到eureka中
@EnableCircuitBreaker  //添加熔断的支持
@EnableDiscoveryClient  //服务发现
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class,args);
    }

    //增加一个ServletRegistrationBean
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
