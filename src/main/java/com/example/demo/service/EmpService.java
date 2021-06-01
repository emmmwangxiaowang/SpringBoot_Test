package com.example.demo.service;

import com.example.demo.bean.Emp;
import java.util.Map;

/**
 * 定义业务层接口
 */
public interface EmpService
{
    //获取信息
    Map <String, Object> getEmp(Emp emp);
}
