package com.yang.service;

import com.yang.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author TangYuan
 * @create 2021--06--09--23:01
 * @description
 */

//fallbackFactory = FeignDeptServiceFallbackFactory.class 开启服务降级的返回信息
@Repository
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = FeignDeptServiceFallbackFactory.class)
public interface FeignDeptService {

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();
}
