package com.afei.config.mvc;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gongxiangfei
 * @describe org.springframework.web.servlet;
 */
public class InterceptorDemo implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {



        if(! (handler instanceof HandlerMethod)){

            //todo
        }








        String contextPath = request.getContextPath();//获取路径的
        Cookie[] cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {

            Cookie cookie = cookies[i];
            if(true){

                String token = cookie.getValue();//获取value下的值，token里面会包含登陆信息，然后进行解密即可

            }

            //
        }

        HttpSession session = request.getSession();

        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
