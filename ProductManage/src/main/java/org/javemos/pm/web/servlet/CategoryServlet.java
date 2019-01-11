package org.javemos.pm.web.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description:
 */
public class CategoryServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(CategoryServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("进入CategoryServlet的doGet方法");
        resp.setContentType("text/html;charset=UTF-8");
        String data = "CategoryServlet返回页面";
        byte[] dataByteArr = data.getBytes("UTF-8");
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(dataByteArr);
        logger.info("CategoryServlet的doGet方法执行完毕");
    }
}
