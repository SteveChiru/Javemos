package org.javemos.pm.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * @Description:
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {
    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        //获取数据
        String value = super.getParameter(name);
        if(value == null) {
            return null;
        }

        //获取请求方式
        String method = super.getMethod();
        if("GET".equals(method)) {
            ////获取数据
            //String value = super.getParameter(name);
            try {
                return new String(value.getBytes("ISO-8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //return super.getParameter(name);
        return value;
    }
}
