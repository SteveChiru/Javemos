package org.javemos.pm.service.impl;

import org.apache.log4j.Logger;
import org.javemos.pm.dao.CategoryDao;
import org.javemos.pm.dao.impl.CategoryDaoImpl;
import org.javemos.pm.domain.Category;
import org.javemos.pm.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public class CategoryServiceImpl implements CategoryService {
    private static Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    private static CategoryDao dao = new CategoryDaoImpl();

    @Override
    public void addCategory(Category c) throws SQLException {
        logger.info("进入服务层-添加分类");
        dao.addCategory(c);
    }

    @Override
    public void delCategoryByCid(Integer cid) throws SQLException {
        logger.info("进入服务层-删除分类");
        dao.delCategoryByCid(cid);
    }

    @Override
    public void updateCategory(Category c) throws SQLException {
        logger.info("进入服务层-修改分类");
        dao.updateCategory(c);
    }

    @Override
    public List<Category> findCategory() throws SQLException {
        logger.info("进入服务层-查找全部分类");
        return dao.findCategory();
    }

    @Override
    public Category findCategoryById(Integer cid) throws Exception {
        logger.info("进入服务层-查找单个分类");
        return dao.findCategoryById(cid);
    }
}
