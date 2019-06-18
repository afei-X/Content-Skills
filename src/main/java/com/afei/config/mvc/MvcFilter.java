
package com.afei.config.mvc;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gongxiangfei
 * @package javax.servlet;
 * @describe  过滤器
 */

@WebFilter(filterName = "TestFilter",urlPatterns = "/*")
public class MvcFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {



        System.out.println("过滤器已启用");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        req.setCharacterEncoding("UTF-8");
        rep.setCharacterEncoding("UTF-8");
        chain.doFilter(req,rep);
    }

    @Override
    public void destroy() {

    }
}

