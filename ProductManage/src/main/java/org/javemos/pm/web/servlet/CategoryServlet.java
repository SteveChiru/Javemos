package org.javemos.pm.web.servlet;

import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.javemos.pm.domain.Category;
import org.javemos.pm.service.CategoryService;
import org.javemos.pm.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public class CategoryServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(CategoryServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("进入CategoryServlet的doGet方法");

        String op = req.getParameter("op");
        if("add".equals(op)) {
            addCategory(req,resp);
        }
        else if("find".equals(op)) {
            findCategory(req,resp);
        }
        else if("del".equals(op)) {
            delCategory(req,resp);
        }
        else if("findById".equals(op)) {
            findCategoryById(req,resp);
        }
        else if("edit".equals(op)) {
            updateCategory(req,resp);
        }
        else if("get".equals(op)) {
            getCategory(req,resp);
        }
    }

    private void getCategory(HttpServletRequest req, HttpServletResponse resp) {
        try {
            CategoryService service = new CategoryServiceImpl();
            //获取所有的分类信息
            List<Category> cs = service.findCategory();
            //将分类信息转换成json格式
            JSONArray jsonArray = JSONArray.fromObject(cs);
            resp.getWriter().println(jsonArray.toString());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Category c = new Category();
            BeanUtils.populate(c, req.getParameterMap());

            CategoryService service = new CategoryServiceImpl();
            service.updateCategory(c);

            req.setAttribute("msg", "修改分类成功！<a href='"+req.getContextPath()+"/CategoryServlet?op=find'>继续查看分类信息</a>");
            req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("msg", "修改分类失败！请联系系统管理员！");
            req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
            return;

        }
    }

    private void findCategoryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取要查询的分类id
            String id = req.getParameter("cid");
            Integer cid = new Integer(id);

            CategoryService service = new CategoryServiceImpl();
            Category c = service.findCategoryById(cid);

            req.setAttribute("c", c);
            req.getRequestDispatcher("/pages/editCategory.jsp").forward(req, resp);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            req.setAttribute("msg", "查询分类失败！请联系系统管理员！");
            req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
            return;
        }
    }

    private void delCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取要删除的分类id
            String id = req.getParameter("cid");
            Integer cid = new Integer(id);

            CategoryService service = new CategoryServiceImpl();
            service.delCategoryByCid(cid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            req.setAttribute("msg", "删除分类失败！请联系系统管理员！");
            req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
            return;

        }

        //获取数据，设置数据，转发
        findCategory(req,resp);
        return;
    }

    private void findCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        try {
            List<Category> cs = service.findCategory();
            req.setAttribute("cs", cs);
            req.getRequestDispatcher("/pages/listCategory.jsp").forward(req, resp);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("msg", "查询分类失败！请联系系统管理员！");
            req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
            return;

        }
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取表单提交的数据并封装成对象
            Category c = new Category();
            //将页面的内容先用request获得，然后再将之转换为Map；最后使用populate方法将各个属性映射到bean中。
            BeanUtils.populate(c, req.getParameterMap());

            System.out.println(c);
            CategoryService service = new CategoryServiceImpl();
            service.addCategory(c);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("msg", "添加分类失败！请联系系统管理员！");
            req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
            return;

        }

        req.setAttribute("msg", "添加分类成功！<a href='"+req.getContextPath()+"/manage/addCategory.jsp'>继续添加！</a>");
        req.getRequestDispatcher("/pages/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
