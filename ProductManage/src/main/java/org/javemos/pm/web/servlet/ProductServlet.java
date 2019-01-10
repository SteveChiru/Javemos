package org.javemos.pm.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description:
 */
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入ProductServlet的doGet方法");
        resp.setContentType("text/html;charset=UTF-8");
        String data = "绿箭口香糖";
        byte[] dataByteArr = data.getBytes("UTF-8");
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(dataByteArr);
        System.out.println("ProductServelt的doGet方法执行完毕");
    }
}
