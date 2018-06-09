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

import com.capacity.platform.system.service.SysUserRoleService;
import com.capacity.platform.system.entity.SysUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 
 * Created by Linux on 2018-06-08.
 */
@Controller
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    private final Logger logger = LoggerFactory.getLogger(SysUserRoleController.class);

    @Autowired
    public SysUserRoleService iSysUserRoleService;

    /**
     * 跳转列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = {"/sysUserRoleIndex"})
    public String index(HttpServletRequest request, Model model) {
        return "sysUserRoleListIndex";
    }

    /**
     * 分页查询数据
     * @return
     */
    @ResponseBody
    @PostMapping("/getSysUserRolePageList")
    public Map<String, Object> getSysUserRoleList() {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
         Page<SysUserRole> page = new Page<>(1, 30);
         EntityWrapper<SysUserRole> wrapper = new EntityWrapper<>();
         // 用户拼接条件查询

         Page<SysUserRole> SysUserRolePage = iSysUserRoleService.selectPage(page, wrapper);
         result.put("total", SysUserRolePage.getTotal());
         result.put("rows", SysUserRolePage.getRecords());
         } catch (Exception e) {
          logger.error("getSysUserRoleList -=- {}",e.toString());
          result.put("total", 0);
          result.put("rows", new ArrayList<SysUserRole>());
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
    @RequestMapping(method=RequestMethod.GET,value="/sysUserRoleAdd")
    public String sysUserRoleAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("sysUserRoleAdd -=- {}",ex.toString());
        }
        return "sysUserRoleAdd";
    }

    /**
     * 跳转修改页面
     * @param request
     * @param id  实体ID
     * @return
     */
    @RequestMapping(method=RequestMethod.GET,value="/sysUserRoleUpdate")
    public String sysUserRoleUpdate(HttpServletRequest request,Integer id) {
        try {
            SysUserRole sysUserRole =iSysUserRoleService.selectById(id);
                request.setAttribute("sysUserRole",sysUserRole);
        }catch (Exception ex){
                logger.error("sysUserRoleUpdate -=- {}",ex.toString());
        }
        return "sysUserRoleUpd";
    }

    /**
     * 保存和修改公用的
     * @param sysUserRole  传递的实体
     * @param model
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST,value="/sysUserRoleSave")
    public int sysUserRoleSave(SysUserRole sysUserRole,Model model){
        int count=0;
        try{
        count=iSysUserRoleService.insertOrUpdate(sysUserRole)?1:0;
        }catch(Exception e){
        logger.error("sysUserRoleSave -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 根据id删除对象
     * @param id  实体ID
     * @return 0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysUserRoleDelete")
    public int sysUserRoleDelete(Integer id){
        int count = 0;
        try {
        count = iSysUserRoleService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysUserRoleDelete -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 批量删除对象
     * @param ids 实体集合ID
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysUserRoleBatchDelete")
    public int deleteBatchIds(List  ids){
        int count = 0;
        try {
        count = iSysUserRoleService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysUserRoleBatchDelete -=- {}",e.toString());
        }
        return count;
    }
}