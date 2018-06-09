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

import com.capacity.platform.system.service.SysRoleMenuService;
import com.capacity.platform.system.entity.SysRoleMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 角色菜单表	
 * Created by Linux on 2018-06-08.
 */
@Controller
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {
    private final Logger logger = LoggerFactory.getLogger(SysRoleMenuController.class);

    @Autowired
    public SysRoleMenuService iSysRoleMenuService;

    /**
     * 跳转列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = {"/sysRoleMenuIndex"})
    public String index(HttpServletRequest request, Model model) {
        return "sysRoleMenuListIndex";
    }

    /**
     * 分页查询数据
     * @return
     */
    @ResponseBody
    @PostMapping("/getSysRoleMenuPageList")
    public Map<String, Object> getSysRoleMenuList() {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
         Page<SysRoleMenu> page = new Page<>(1, 30);
         EntityWrapper<SysRoleMenu> wrapper = new EntityWrapper<>();
         // 用户拼接条件查询

         Page<SysRoleMenu> SysRoleMenuPage = iSysRoleMenuService.selectPage(page, wrapper);
         result.put("total", SysRoleMenuPage.getTotal());
         result.put("rows", SysRoleMenuPage.getRecords());
         } catch (Exception e) {
          logger.error("getSysRoleMenuList -=- {}",e.toString());
          result.put("total", 0);
          result.put("rows", new ArrayList<SysRoleMenu>());
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
    @RequestMapping(method=RequestMethod.GET,value="/sysRoleMenuAdd")
    public String sysRoleMenuAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("sysRoleMenuAdd -=- {}",ex.toString());
        }
        return "sysRoleMenuAdd";
    }

    /**
     * 跳转修改页面
     * @param request
     * @param id  实体ID
     * @return
     */
    @RequestMapping(method=RequestMethod.GET,value="/sysRoleMenuUpdate")
    public String sysRoleMenuUpdate(HttpServletRequest request,Integer id) {
        try {
            SysRoleMenu sysRoleMenu =iSysRoleMenuService.selectById(id);
                request.setAttribute("sysRoleMenu",sysRoleMenu);
        }catch (Exception ex){
                logger.error("sysRoleMenuUpdate -=- {}",ex.toString());
        }
        return "sysRoleMenuUpd";
    }

    /**
     * 保存和修改公用的
     * @param sysRoleMenu  传递的实体
     * @param model
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST,value="/sysRoleMenuSave")
    public int sysRoleMenuSave(SysRoleMenu sysRoleMenu,Model model){
        int count=0;
        try{
        count=iSysRoleMenuService.insertOrUpdate(sysRoleMenu)?1:0;
        }catch(Exception e){
        logger.error("sysRoleMenuSave -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 根据id删除对象
     * @param id  实体ID
     * @return 0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysRoleMenuDelete")
    public int sysRoleMenuDelete(Integer id){
        int count = 0;
        try {
        count = iSysRoleMenuService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysRoleMenuDelete -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 批量删除对象
     * @param ids 实体集合ID
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysRoleMenuBatchDelete")
    public int deleteBatchIds(List  ids){
        int count = 0;
        try {
        count = iSysRoleMenuService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysRoleMenuBatchDelete -=- {}",e.toString());
        }
        return count;
    }
}