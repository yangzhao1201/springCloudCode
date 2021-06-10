package com.yang.service;

import com.yang.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author TangYuan
 * @create 2021--06--10--00:32
 * @description hystrix降级
 */
//hystrix降级
//服务熔断是在服务端完成 而降级是在客户端完成 组客户访问并给出提示信息
@Component
public class FeignDeptServiceFallbackFactory implements FallbackFactory {
    @Override
    public FeignDeptService create(Throwable throwable) {
        return new FeignDeptService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setId(id)
                        .setDname("服务降级，没有对应的信息")
                        .setDb_source("no database");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
