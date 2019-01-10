package org.javemos.pm.web.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 */
public class EncodingFilter implements Filter {
    private static Logger logger = Logger.getLogger(EncodingFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("进入EncodingFilter的doFilter方法");
        MyHttpServletRequest req = new MyHttpServletRequest((HttpServletRequest) servletRequest);
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //设置响应类型编码
        resp.setContentType("text/html;charset=UTF-8");
        //设置请求编码
        req.setCharacterEncoding("UTF-8");

        filterChain.doFilter(req,resp);

        logger.info("EncodingFilter的doFilter方法执行完毕");
    }

    public void destroy() {

    }
}
