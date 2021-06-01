package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.Emp;
import com.example.demo.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class DemoApplicationTests
{

    //依赖注入:也可以使用@Autowired
    @Resource
    private EmpMapper empMapper;

    @Resource
    private Emp emp;

    @Test
    void insert()
    {
        int result = empMapper.insert(emp);
        System.out.println("===========》" + result);
    }

    //删除功能:
    @Test
    void deleteById()
    {
        int result = empMapper.deleteById(7937);
        System.out.println("===========》" + result);
    }

    //删除功能:deleteByMap
    @Test
    void deleteByMap()
    {
        Map <String, Object> map = new HashMap <>();
        map.put("deptno", 30);
        map.put("sal", 1250);
        int result = empMapper.deleteByMap(map);
        System.out.println("===========》" + result);
    }

    //删除功能:
    @Test
    void delete()
    {
        //创建条件构造器
        QueryWrapper queryWrapper = new QueryWrapper <>();
        queryWrapper.eq("deptno", 30);
        queryWrapper.ge("sal", 1000);
        queryWrapper.like("ename", "A");
        queryWrapper.or();
        queryWrapper.isNull("comm");
        int result = empMapper.delete(queryWrapper);
        System.out.println("===========》" + result);
    }

    //删除功能:deleteBatchIds
    @Test
    void deleteBatchIds()
    {

        Integer[] arrays = new Integer[]{7369, 7782, 7839};
        Integer   result = empMapper.deleteBatchIds(Arrays.asList(arrays));
        System.out.println("===========》" + result);
    }

    //更新:updateById
    @Test
    void updateById()
    {
        Integer result = empMapper.updateById(emp);
        System.out.println("===========》" + result);
    }

    //更新:update
    @Test
    void update()
    {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.isNotNull("comm");
        updateWrapper.set("sal", 9999);
        Integer result = empMapper.update(emp, updateWrapper);
        System.out.println("===========》" + result);
    }

    //查找:selectById
    @Test
    void selectById()
    {
        Emp emp = empMapper.selectById(7788);
        System.out.println("===========》" + emp);
    }

    //查找:selectBatchIds
    @Test
    void selectBatchIds()
    {
        List <Integer> list = new ArrayList <>();
        list.add(7369);
        list.add(7782);
        list.add(7839);
        List <Emp> arrayList = new ArrayList <>();
        arrayList = empMapper.selectBatchIds(list);
        System.out.println("===========》" + arrayList);
    }

    //查找:selectList
    @Test
    void selectList()
    {
        List <Emp> list = new ArrayList <>();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deptno", 30);
        queryWrapper.between("sal", 1000, 3000);
        list = empMapper.selectList(queryWrapper);
        System.out.println("===========》" + list);
    }

    //分页动态查询功能:selectMapsPage
    @Test
    void selectMapsPage()
    {//----
        Page page = new Page(1, 8);

        List <Emp> list = new ArrayList <>();

        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.ge(emp.getHiredatefrom() != null, "hiredate", emp.getHiredatefrom());
        queryWrapper.le(emp.getHiredateto() != null, "hiredate", emp.getHiredateto());
        queryWrapper.eq(emp.getDeptno() != null, "deptno", emp.getDeptno());
        queryWrapper.like(emp.getEname() != null, "ename", emp.getEname());

        IPage <Emp> iPage = empMapper.selectMapsPage(page, queryWrapper);
        System.out.println("===========》" + iPage.getTotal());
        System.out.println("===========》" + iPage.getRecords());
    }

}
