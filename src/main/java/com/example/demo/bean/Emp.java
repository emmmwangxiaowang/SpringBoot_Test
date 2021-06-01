package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;

/**
 * 定义POJO类
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "emp")
public class Emp implements Serializable
{
    @TableId(value = "empno", type = IdType.AUTO)
    private Integer empno;   //员工编号
    private String  ename;   //员工姓名
    private String  job;     //工作职位
    private Integer mgr;     //领导编号
    private Date    hiredate;//入职日期
    @TableField(exist = false)
    private Date    hiredatefrom;//入职日期
    @TableField(exist = false)
    private Date    hiredateto;//入职日期
    private Double  sal;     //员工工资
    private Double  comm;    //员工奖金
    private Integer deptno;  //部门编号
    @TableField(exist = false)//表示这个属性在表中不存在
    private Integer page;   //当前页码数

    @TableField(exist = false)
    private Integer rows;   //每页显示的件数
}

