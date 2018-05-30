package com.capacity.platform.system.controller;

import com.capacity.platform.common.result.Result;
import com.capacity.platform.common.result.ResultGenerator;
import com.capacity.platform.system.entity.SysUser;
import com.capacity.platform.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: ICL
 * Date:2018/5/19
 * Description:
 * Created by ICL on 2018/5/19.
 */
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result list(){
       List<SysUser> list= sysUserService.findAll(null);
        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result get(@PathVariable String id ){
       SysUser sysUser= sysUserService.find(id);
        return ResultGenerator.genSuccessResult(sysUser);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result post(SysUser sysUser){
        sysUserService.save(sysUser);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable String id,SysUser sysUser){
        sysUserService.update(sysUser);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        sysUserService.delete(id);
        return ResultGenerator.genSuccessResult();

    }
}
