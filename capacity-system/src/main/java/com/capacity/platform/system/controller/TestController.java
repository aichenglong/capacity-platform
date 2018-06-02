package com.capacity.platform.system.controller;
import com.capacity.platform.system.entity.Test;
import com.capacity.platform.system.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;


/**
 * Author: icl
 * Date:2018/06/02
 * Description: 使用DatabaseContextHolder获取当前线程的DatabaseType
 * Created by icl on 2018/06/02.
 */
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    TestService testService;

    /**
     * 通过id进行查询
     * @return
     */
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String findTestById(@PathVariable Integer id){

        System.out.println(id);
        return testService.findTestById(id).toString();
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  addTest(){
        Test test = new Test();
        int randomNum = new Random(10).nextInt();
        test.setName("my name" + randomNum);
        test.setNote("this is add element to test table");
        int result= testService.add(test);
        System.out.println("add result ="+result);

        if (result >0) {
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 通过id删除
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String  deleteTestById(){

        int result= testService.deleteById(5);
        System.out.println("deleteTestById result ="+result);
        if (result > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    /**
     * 通过id更新
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String  updateTestById(){
        Test test = new Test();
        test.setId(6);
        test.setName("this is updete name ");
        test.setNote("this is update note");
        int result= testService.updateTest(test);
        System.out.println("updateTestById result ="+result);
        if (result > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

    /**
     * 通过名字进行模糊查询
     * @return
     */
    @RequestMapping(value = "/findname",method = RequestMethod.GET)
    public String  findByName(){
        List<Test> result= testService.findByName("jack");
        System.out.println("updateTestById result ="+result.toString());
        if (result != null) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }
}