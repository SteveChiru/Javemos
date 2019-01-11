package org.javemos.pm.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.javemos.pm.domain.Product;
import org.javemos.pm.service.ProductService;
import org.javemos.pm.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 */
public class ProductServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("进入ProductServlet的doGet方法");

        String op = req.getParameter("op");
        if ("add".equals(op)){
            addProduct(req,resp);
        }

    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            boolean flag = ServletFileUpload.isMultipartContent(req);
            if(!flag) {
                setMsg(req, resp,"请求方式错误！");
                return;
            }

            //创建磁盘工厂对象
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            //创建文件上传的核心对象
            ServletFileUpload upload = new ServletFileUpload(dfif);
            //解析请求对象
            List<FileItem> items = upload.parseRequest(req);

            Product p = new Product();

            for (FileItem fileItem : items) {
                if(fileItem.isFormField()) {
                    //普通表单项
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
				/*	if("pname".equals(name)) {
						p.setPname(value);
					}*/

                    BeanUtils.setProperty(p, name, value);

                }
                else {
                    //文件上传表单项
                    //获取文件的mime类型
                    String mimeType = fileItem.getContentType();
                    //判断文件类型
                    if(!mimeType.startsWith("image")) {
                        setMsg(req,resp,"附件类型错误！请上传图片！");
                        return;
                    }

                    //获取文件名称
                    String fileName = fileItem.getName();
                    String newFileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(fileName);

                    //获取路径
                    //获取当前日期
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    String now = sdf.format(new Date());
                    String realPath = getServletContext().getRealPath("/images/" + now);


                    File imageFile = new File(realPath);
                    if(!imageFile.exists()) {
                        imageFile.mkdirs();
                    }

//					System.out.println(realPath);

                    File uploadFile = new File(realPath,newFileName);
                    fileItem.write(uploadFile);

                    //手动设置图片路径
                    p.setPath("/images/" + now + "/" + newFileName);
                }
            }

            ProductService service = new ProductServiceImpl();
            service.addProduct(p);
            setMsg(req, resp, "添加商品成功！<a href='"+req.getContextPath()+"/manage/addProduct.jsp'>继续添加</a>");
            return;


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            setMsg(req, resp, "添加商品失败！请联系管理员！");
            return;
        }
    }

    private void setMsg(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/pages/message.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
