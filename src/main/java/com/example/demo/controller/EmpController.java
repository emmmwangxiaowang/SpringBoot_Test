package com.example.demo.controller;

import com.example.demo.bean.Emp;
import com.example.demo.service.EmpService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

/**
 * 定义控制器
 */
@CrossOrigin //浏览器跨域
@RestController //表明当前类充当控制器(请求---响应)、自动以JSON格式返回数据
public class EmpController
{
    //通过依赖注入:业务层的接口
    @Resource
    private EmpService empService;

    @RequestMapping("/getEmp")
    public Map <String, Object> getEmp(Emp emp)
    {
//        Map <String, Object> map = new HashMap <>();
        return empService.getEmp(emp);
    }
}
