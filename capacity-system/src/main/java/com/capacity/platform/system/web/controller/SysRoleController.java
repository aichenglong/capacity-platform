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

import com.capacity.platform.system.service.SysRoleService;
import com.capacity.platform.system.entity.SysRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 角色表
 * Created by Linux on 2018-06-08.
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
    private final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    public SysRoleService iSysRoleService;

    /**
     * 跳转列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = {"/sysRoleIndex"})
    public String index(HttpServletRequest request, Model model) {
        return "sysRoleListIndex";
    }

    /**
     * 分页查询数据
     * @return
     */
    @ResponseBody
    @PostMapping("/getSysRolePageList")
    public Map<String, Object> getSysRoleList() {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
         Page<SysRole> page = new Page<>(1, 30);
         EntityWrapper<SysRole> wrapper = new EntityWrapper<>();
         // 用户拼接条件查询

         Page<SysRole> SysRolePage = iSysRoleService.selectPage(page, wrapper);
         result.put("total", SysRolePage.getTotal());
         result.put("rows", SysRolePage.getRecords());
         } catch (Exception e) {
          logger.error("getSysRoleList -=- {}",e.toString());
          result.put("total", 0);
          result.put("rows", new ArrayList<SysRole>());
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
    @RequestMapping(method=RequestMethod.GET,value="/sysRoleAdd")
    public String sysRoleAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("sysRoleAdd -=- {}",ex.toString());
        }
        return "sysRoleAdd";
    }

    /**
     * 跳转修改页面
     * @param request
     * @param id  实体ID
     * @return
     */
    @RequestMapping(method=RequestMethod.GET,value="/sysRoleUpdate")
    public String sysRoleUpdate(HttpServletRequest request,Integer id) {
        try {
            SysRole sysRole =iSysRoleService.selectById(id);
                request.setAttribute("sysRole",sysRole);
        }catch (Exception ex){
                logger.error("sysRoleUpdate -=- {}",ex.toString());
        }
        return "sysRoleUpd";
    }

    /**
     * 保存和修改公用的
     * @param sysRole  传递的实体
     * @param model
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST,value="/sysRoleSave")
    public int sysRoleSave(SysRole sysRole,Model model){
        int count=0;
        try{
        count=iSysRoleService.insertOrUpdate(sysRole)?1:0;
        }catch(Exception e){
        logger.error("sysRoleSave -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 根据id删除对象
     * @param id  实体ID
     * @return 0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysRoleDelete")
    public int sysRoleDelete(Integer id){
        int count = 0;
        try {
        count = iSysRoleService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysRoleDelete -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 批量删除对象
     * @param ids 实体集合ID
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysRoleBatchDelete")
    public int deleteBatchIds(List  ids){
        int count = 0;
        try {
        count = iSysRoleService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysRoleBatchDelete -=- {}",e.toString());
        }
        return count;
    }
}