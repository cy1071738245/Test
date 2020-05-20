package com.cy.controller;

import com.cy.entity.User;
import com.cy.service.UserService;
import com.cy.util.MD5Utils;
import com.cy.util.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import static java.util.Objects.nonNull;

@Controller
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @PostMapping("register")
    public void register(@RequestParam("userName") String userName,
                                 @RequestParam("password") String password,
                                 @RequestParam("realName") String realName) {
        int count = userService.register(userName, MD5Utils.passToMD5(password), realName);
        if (count > 0) {
            ResultUtils.ajaxPrintWriter("success", response);
        }
    }

    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 登录密码
     */
    @PostMapping("login")
    public void login(@RequestParam("userName") String userName,
                           @RequestParam("password") String password) {
        User user = userService.login(userName, MD5Utils.passToMD5(password));
        if (nonNull(user)) {
            request.getSession().setAttribute("user", user);
            ResultUtils.ajaxPrintWriter("success", response);
        }
    }

    @GetMapping("logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        request.getSession().removeAttribute("user");
        mav.setViewName("redirect:login");
        return mav;
    }

}
