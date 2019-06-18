package com.afei.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author gongxiangfei
 * @version 1.0
 * @description 过滤器的使用
 */
public class FilterDemo implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


        System.out.println("init filter start");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {








    }

    @Override
    public void destroy() {

    }
}
