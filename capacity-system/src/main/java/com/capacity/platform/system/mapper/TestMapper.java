package com.capacity.platform.system.mapper;


import com.capacity.platform.system.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author huangqingshi
 * @Date 2018.04.11
 * 接口，对Test表进行操作
 * 可以不用@Mapper，通过将如下代码加入到SpringBootDemoApiApplication上面就行。
 */
@Mapper
public interface TestMapper {
    Test findTestById(int id);

    int add(Test test);

    int deleteById(int id);

    int updateByID(Test test);

    List<Test> findByName(String name);
}