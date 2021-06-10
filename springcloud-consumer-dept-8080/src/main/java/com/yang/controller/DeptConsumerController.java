package com.yang.controller;

import com.yang.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author TangYuan
 * @create 2021--06--09--03:43
 * @description
 */

@RestController
public class DeptConsumerController {

    //restful风格 restTemplate模板
    @Autowired
    private RestTemplate restTemplate;

    //ribbon 负载均衡 地址应该是一个变量 所以应该通过服务名访问
    //private static final String REST_URL_PREFIX = "http://localhost:8081";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";


    @PostMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    //produces = { "application/json;charset=UTF-8"} 设置eureka返回格式为json
    @RequestMapping(value = "/consumer/dept/get/{id}",produces = { "application/json;charset=UTF-8"})
    public Dept queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",produces = { "application/json;charset=UTF-8"})
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
