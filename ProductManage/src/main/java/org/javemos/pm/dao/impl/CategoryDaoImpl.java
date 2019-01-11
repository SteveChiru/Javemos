package org.javemos.pm.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.javemos.pm.dao.CategoryDao;
import org.javemos.pm.domain.Category;
import org.javemos.pm.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public class CategoryDaoImpl implements CategoryDao {
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public void addCategory(Category c) throws SQLException {
        qr.update("insert into category (cname,description) values (?,?)",c.getCname(),c.getDescription());
    }

    @Override
    public void delCategoryByCid(Integer cid) throws SQLException {
        qr.update("delete from category where cid = ?",cid);
    }

    @Override
    public void updateCategory(Category c) throws SQLException {
        qr.update("update category set cname = ?,description = ? where cid = ?",c.getCname(),c.getDescription(),c.getCid());
    }

    @Override
    public List<Category> findCategory() throws SQLException {
        return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
    }

    @Override
    public Category findCategoryById(Integer cid) throws Exception {
        return qr.query("select * from category where cid = ?", new BeanHandler<Category>(Category.class),cid);
    }
}
