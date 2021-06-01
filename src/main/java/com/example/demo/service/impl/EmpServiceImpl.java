package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.Emp;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现业务接口
 */
//事务管理
//Propagation.NOT_SUPPORTED只考虑增删改
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
@Service
public class EmpServiceImpl implements EmpService
{
    @Resource
    private EmpMapper empMapper;

    //获取信息
    public Map <String, Object> getEmp(Emp emp)
    {
        Map <String, Object> map = new HashMap <>();

        //填充档期那页面数和每页显示数据数
        Page page = new Page(emp.getPage(), emp.getRows());

        List <Emp> list = new ArrayList <>();

        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.ge(emp.getHiredatefrom() != null, "hiredate", emp.getHiredatefrom());
        queryWrapper.le(emp.getHiredateto() != null, "hiredate", emp.getHiredateto());
        queryWrapper.eq(emp.getDeptno() != null, "deptno", emp.getDeptno());
        queryWrapper.like(emp.getEname() != null, "ename", emp.getEname());

        IPage <Emp> iPage = empMapper.selectMapsPage(page, queryWrapper);
        map.put("total", iPage.getTotal());
        map.put("rows", iPage.getRecords());

        return map;
    }
}
