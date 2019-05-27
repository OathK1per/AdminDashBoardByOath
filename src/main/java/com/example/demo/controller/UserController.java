package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 从一个controller调用另一个controller的三种方法
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {

        boolean login = userService.login(user);
        if (login) {
            /**
             * 这里存放的Session名称不能和上面的参数User同名，不然会误以为你一直在获取Session
             */
            if (user != null && request.getSession().getAttribute("userSession") == null) {
                request.getSession().setAttribute("userSession", user);
            }

            return "redirect:/category?page=1";
        } else {
            request.setAttribute("failedLogin", "用户名错误 或者 密码错误，请重试");
            return "login";
        }
    }

    /**
     *
     * @Todo 增加一个登出功能
     * @Todo 对ftl页面的switch，使其能够保持在注册页而不是返回登录页
     */

    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request) {

        boolean register = userService.register(user);
        if (register) {
            return "login";
        }
        request.setAttribute("failedRegister", "用户名已被使用，请重新输入");
        return "login";
    }

    @RequestMapping("/redirectLogin")
    public String toLogin() {
        return "login";
    }
}
