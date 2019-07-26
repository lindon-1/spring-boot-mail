package com.example.demo.controller;

import com.example.demo.Msg;
import com.example.demo.entity.SysUser;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author: ldl
 * @Date: 2019/7/16 16:54
 */
@Controller
public class HomeController {
    @Resource
    UserService userService;
    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping(value = "/log",method = RequestMethod.POST)
    public String login(@RequestBody String username, @RequestBody String password) {
        SysUser sysUser = userService.findByUserName(username);
        if (sysUser != null && password.equals(sysUser.getPassword()))
            return "/home";
        else
            return "/login";
    }

    @RequestMapping(value = "/logi",method = RequestMethod.GET)
    public String log() {
        return "login";
    }

}
