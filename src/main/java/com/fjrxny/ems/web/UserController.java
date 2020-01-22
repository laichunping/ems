package com.fjrxny.ems.web;

import com.fjrxny.ems.pojo.User;
import com.fjrxny.ems.service.UserService;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 进入登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login(HttpSession session) {

        Object logonUser = session.getAttribute("logonUser");
        if (logonUser != null) {
            return "redirect:/";
        }
        return "login";
    }

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        if (StringUtils.isEmpty(user.getUserId()) || StringUtils.isEmpty(user.getPassword())) {
            model.addAttribute("msg", "用户名不允许为空");
            return "login";
        }
        user.setUserName(user.getUserId());
        user = userService.login(user);
        if (user == null) {
            model.addAttribute("msg", "用户名或密码不正确");
            return "login";
        }
        session.setAttribute("logonUser", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("logonUser");
        return "redirect:/login";
    }
}
