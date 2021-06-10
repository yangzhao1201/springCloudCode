package com.yang.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author TangYuan
 * @create 2021--06--09--03:46
 * @description
 */

@Configuration
public class ConfigBean {

    //设置负载均衡 IRule
    //默认轮询机制
    @Bean
    @LoadBalanced //配置负载均衡 ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    //设置负载均衡随机访问
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }
}
