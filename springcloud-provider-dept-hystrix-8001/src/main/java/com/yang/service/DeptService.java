package com.yang.service;

import com.yang.pojo.Dept;

import java.util.List;

/**
 * @author TangYuan
 * @create 2021--06--09--03:09
 * @description
 */

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
