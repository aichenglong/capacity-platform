package com.capacity.platform.system.web.controller;

import com.capacity.platform.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public SysUserService iSysUserService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List listUser(){
        return iSysUserService.selectList(null);
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public SysUser create(@RequestBody SysUser user){
//        return iSysUserService.insert(user);
//    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") String id){
        iSysUserService.deleteById(id);
        return "success";
    }

}