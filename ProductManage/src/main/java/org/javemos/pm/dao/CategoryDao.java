package org.javemos.pm.dao;

import org.javemos.pm.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public interface CategoryDao {
    public void addCategory(Category c) throws SQLException;
    public void delCategoryByCid(Integer cid) throws SQLException;
    public void updateCategory(Category c) throws SQLException;
    public List<Category> findCategory() throws SQLException;
    public Category findCategoryById(Integer cid) throws Exception;
}
