package com.capacity.platform.system.service;

import com.capacity.platform.system.entity.Test;
import com.capacity.platform.system.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Author: icl
 * Date:2018/06/02
 * Description:
 * Created by icl on 2018/06/02.
 */
@Service("testService")
public class TestService {
    @Resource
    private TestMapper testMapper;


    public Test findTestById (int id) {
        Test test = testMapper.findTestById(id);
        return test;
    }

    public int add(Test test) {
        int addCount = testMapper.add(test);
        return addCount;
    }

    public int deleteById(int id) {
        int deleteId = testMapper.deleteById(id);
        return deleteId;
    }

    public int updateTest(Test test) {
        int id = testMapper.updateByID(test);
        return id;
    }

    public List<Test> findByName(String name) {
        List<Test> test = testMapper.findByName(name);
        return test;
    }

}
