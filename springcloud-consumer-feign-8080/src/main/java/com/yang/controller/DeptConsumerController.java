package com.yang.controller;

import com.yang.pojo.Dept;
import com.yang.service.FeignDeptService;
import org.springframework.beans.factory.annotation.Autowired;
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
    //feign更像面向接口编程，相当于对restTemplate进行了再一次的封装
    @Autowired
    private FeignDeptService feignDeptService;

    @PostMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return this.feignDeptService.addDept(dept);
    }

    //produces = { "application/json;charset=UTF-8"} 设置eureka返回格式为json
    @RequestMapping(value = "/consumer/dept/get/{id}",produces = { "application/json;charset=UTF-8"})
    public Dept queryById(@PathVariable("id") Long id){
        return this.feignDeptService.queryById(id);
    }

    @RequestMapping(value = "/consumer/dept/list",produces = { "application/json;charset=UTF-8"})
    public List<Dept> queryAll(){
        return this.feignDeptService.queryAll();
    }

}
