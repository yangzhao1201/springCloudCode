package com.yang.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author TangYuan
 * @create 2021--06--09--02:15
 * @description
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  //开启链式写法
public class Dept implements Serializable {
    private Long id;
    private String dname;
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
