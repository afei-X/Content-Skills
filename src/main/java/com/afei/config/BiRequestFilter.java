package com.afei.config;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gongxiangfei
 * @describe 交叉报表请求入参特殊字符的处理
 * @datatime 2018-11-09
 */
@WebFilter(urlPatterns = "/*")
public class BiRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {



        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        String data = req.getParameter("queryStr");
        if(StringUtils.isNotBlank(data)){

            //data = data.replaceAll("%2B", "+").replaceAll("%25", "%");


        }

        chain.doFilter(req,rep);


    }

    @Override
    public void destroy() {

    }
}
