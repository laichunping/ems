package com.fjrxny.ems.interceptor;

import com.fjrxny.ems.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User logonUser = (User) request.getSession().getAttribute("logonUser");
        if (logonUser == null) {
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
