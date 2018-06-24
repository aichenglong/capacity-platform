package com.capacity.platform.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: icl
 * Date:2018/06/10
 * Description:
 * Created by icl on 2018/06/10.
 */
@Controller
public class HomeController {


    @RequestMapping("/")
    public String index(Model model){
//        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
//        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
