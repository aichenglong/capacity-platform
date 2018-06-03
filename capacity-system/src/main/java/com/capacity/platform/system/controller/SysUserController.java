package com.capacity.platform.system.controller;

import com.capacity.platform.common.result.Result;
import com.capacity.platform.common.result.ResultGenerator;
import com.capacity.platform.system.entity.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: icl
 * Date:2018/06/03
 * Description:
 * Created by icl on 2018/06/03.
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @RequestMapping(method = RequestMethod.GET)
    public Result findByUser(){
        SysUser sysUser=new SysUser();
        return ResultGenerator.genSuccessResult(sysUser);
    }

}
