package com.capacity.platform.system.controller;

import com.capacity.platform.common.result.Result;
import com.capacity.platform.common.result.ResultGenerator;
import com.capacity.platform.system.entity.SysMenu;
import com.capacity.platform.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: icl
 * Date:2018/06/03 22:18:24
 * Description:
 * Created by icl on 2018/06/03 22:18:24.
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result list(){
       List< SysMenu> list=  sysMenuService.findAll(null);
    return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result get(@PathVariable String id ){
       SysMenu sysMenu= sysMenuService.find(id);
    return ResultGenerator.genSuccessResult(sysMenu);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result post(SysMenu sysMenu){
       sysMenuService.save(sysMenu);
    return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable String id,SysMenu sysMenu){
      sysMenuService.update(sysMenu);
    return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
       sysMenuService.delete(id);
    return ResultGenerator.genSuccessResult();

    }
}
