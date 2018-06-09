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

import com.capacity.platform.system.service.SysMenuService;
import com.capacity.platform.system.entity.SysMenu;
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
@RequestMapping("/sysMenu")
public class SysMenuController {
    private final Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    public SysMenuService iSysMenuService;

    /**
     * 跳转列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = {"/sysMenuIndex"})
    public String index(HttpServletRequest request, Model model) {
        return "sysMenuListIndex";
    }

    /**
     * 分页查询数据
     * @return
     */
    @ResponseBody
    @PostMapping("/getSysMenuPageList")
    public Map<String, Object> getSysMenuList() {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
         Page<SysMenu> page = new Page<>(1, 30);
         EntityWrapper<SysMenu> wrapper = new EntityWrapper<>();
         // 用户拼接条件查询

         Page<SysMenu> SysMenuPage = iSysMenuService.selectPage(page, wrapper);
         result.put("total", SysMenuPage.getTotal());
         result.put("rows", SysMenuPage.getRecords());
         } catch (Exception e) {
          logger.error("getSysMenuList -=- {}",e.toString());
          result.put("total", 0);
          result.put("rows", new ArrayList<SysMenu>());
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
    @RequestMapping(method=RequestMethod.GET,value="/sysMenuAdd")
    public String sysMenuAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("sysMenuAdd -=- {}",ex.toString());
        }
        return "sysMenuAdd";
    }

    /**
     * 跳转修改页面
     * @param request
     * @param id  实体ID
     * @return
     */
    @RequestMapping(method=RequestMethod.GET,value="/sysMenuUpdate")
    public String sysMenuUpdate(HttpServletRequest request,Integer id) {
        try {
            SysMenu sysMenu =iSysMenuService.selectById(id);
                request.setAttribute("sysMenu",sysMenu);
        }catch (Exception ex){
                logger.error("sysMenuUpdate -=- {}",ex.toString());
        }
        return "sysMenuUpd";
    }

    /**
     * 保存和修改公用的
     * @param sysMenu  传递的实体
     * @param model
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST,value="/sysMenuSave")
    public int sysMenuSave(SysMenu sysMenu,Model model){
        int count=0;
        try{
        count=iSysMenuService.insertOrUpdate(sysMenu)?1:0;
        }catch(Exception e){
        logger.error("sysMenuSave -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 根据id删除对象
     * @param id  实体ID
     * @return 0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysMenuDelete")
    public int sysMenuDelete(Integer id){
        int count = 0;
        try {
        count = iSysMenuService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysMenuDelete -=- {}",e.toString());
        }
        return count;
    }

    /**
     * 批量删除对象
     * @param ids 实体集合ID
     * @return  0 失败  1 成功
     */
    @ResponseBody
    @RequestMapping(method= RequestMethod.POST,value="/sysMenuBatchDelete")
    public int deleteBatchIds(List  ids){
        int count = 0;
        try {
        count = iSysMenuService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("sysMenuBatchDelete -=- {}",e.toString());
        }
        return count;
    }
}