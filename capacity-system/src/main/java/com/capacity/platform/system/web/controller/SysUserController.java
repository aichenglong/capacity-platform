package com.capacity.platform.system.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

import com.capacity.platform.system.service.SysUserService;
import com.capacity.platform.system.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 用户表
 * Created by Linux on 2018-06-08.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    private final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    public SysUserService iSysUserService;

    /**
     * 跳转列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = {"/sysUserIndex"})
    public String index(HttpServletRequest request, Model model) {
        return "sysUserListIndex";
    }

    /**
     * 分页查询数据
     * @return
     */
    @ResponseBody
    @PostMapping("/getSysUserPageList")
    public Map<String, Object> getSysUserList() {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
         Page<SysUser> page = new Page<>(1, 30);
         EntityWrapper<SysUser> wrapper = new EntityWrapper<>();
         // 用户拼接条件查询

         Page<SysUser> SysUserPage = iSysUserService.selectPage(page, wrapper);
         result.put("total", SysUserPage.getTotal());
         result.put("rows", SysUserPage.getRecords());
         } catch (Exception e) {
          logger.error("getSysUserList -=- {}",e.toString());
          result.put("total", 0);
          result.put("rows", new ArrayList<SysUser>());
        }
        return result;
    }

    /**
     * 跳转添加页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(method=RequestMethod.GET,value="/sysUserAdd")
    public String sysUserAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("sysUserAdd -=- {}",ex.toString());
        }
        return "sysUserAdd";
    }

    /**
     * 跳转修改页面
     * @param request
     * @param id  实体ID
     * @return
     */
    @RequestMapping(method=RequestMethod.GET,value="/sysUserUpdate")
    public String sysUserUpdate(HttpServletRequest request,Integer id) {
        try {
            SysUser sysUser =iSysUserService.selectById(id);
                request.setAttribute("sysUser",sysUser);
        }catch (Exception ex){
                logger.error("sysUserUpdate -=- {}",ex.toString());
        }
        return "sysUserUpd";
    }

    /**
     * 保存和修改公用的
     * @param sysUser  传递的实体
     * @param model
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST,value="/sysUserSave")
    public int sysUserSave(SysUser sysUser,Model model){
        int count=0;
        try{
        count=iSysUserService.insertOrUpdate(sysUser)?1:0;
        }catch(Exception e){
        logger.error("sysUserSave -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 根据id删除对象
     * @param id  实体ID
     * @return 0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysUserDelete")
    public int sysUserDelete(Integer id){
        int count = 0;
        try {
        count = iSysUserService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysUserDelete -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 批量删除对象
     * @param ids 实体集合ID
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysUserBatchDelete")
    public int deleteBatchIds(List  ids){
        int count = 0;
        try {
        count = iSysUserService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysUserBatchDelete -=- {}",e.toString());
        }
        return count;
    }
}