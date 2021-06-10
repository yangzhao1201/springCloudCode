package com.yang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yang.pojo.Dept;
import com.yang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TangYuan
 * @create 2021--06--09--03:13
 * @description  提供Restful服务
 */

@RestController
public class DeptController { //提供Restful服务

    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "queryByIdHystrix")  //开启备选方案
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        //如果id不存在会报错
        if (dept == null) {
            throw new RuntimeException("id=>"+id+"不存在，或信息无法找到");
        }
        return dept;
    }

    //备选方法
    public Dept queryByIdHystrix(@PathVariable("id") Long id){
        return new Dept()
                .setId(id)
                .setDname("id=>"+id+"不存在,null @Hystrix")
                .setDb_source("no database in MySQL");
    }

}
