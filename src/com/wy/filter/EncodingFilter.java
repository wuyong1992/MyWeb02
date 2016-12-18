package com.wy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by wuyong on 2016/12/18.
 */
@WebFilter(filterName = "EncodingFilter", initParams = {@WebInitParam(name = "charset", value = "utf-8")})

public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest res = (HttpServletRequest) request;

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {


    }

}
