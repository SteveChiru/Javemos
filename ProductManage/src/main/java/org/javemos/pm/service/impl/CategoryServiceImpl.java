package org.javemos.pm.service.impl;

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
    private static CategoryDao dao = new CategoryDaoImpl();

    @Override
    public void addCategory(Category c) throws SQLException {
        dao.addCategory(c);
    }

    @Override
    public void delCategoryByCid(Integer cid) throws SQLException {
        dao.delCategoryByCid(cid);
    }

    @Override
    public void updateCategory(Category c) throws SQLException {
        dao.updateCategory(c);
    }

    @Override
    public List<Category> findCategory() throws SQLException {
        return dao.findCategory();
    }

    @Override
    public Category findCategoryById(Integer cid) throws Exception {
        return dao.findCategoryById(cid);
    }
}
