package org.javemos.pm.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import org.javemos.pm.dao.ProductDao;
import org.javemos.pm.domain.Product;
import org.javemos.pm.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public class ProductDaoImpl implements ProductDao {
    private static Logger logger = Logger.getLogger(ProductDaoImpl.class);
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public void addProduct(Product p) throws SQLException {
        logger.info("进入持久层-添加商品");
        qr.update("insert into product (pname,price,path,pdescription,categoryid) values (?,?,?,?,?)",p.getPname(),p.getPrice(),p.getPath(),p.getPdescription(),p.getCategoryid());
    }

    @Override
    public void delProduct(Integer pid) throws SQLException {
        logger.info("进入持久层-删除商品");
        qr.update("delete from product where pid = ?",pid);
    }

    @Override
    public void updateProduct(Product p) throws SQLException {
        logger.info("进入持久层-修改商品");
        qr.update("update product set pname=?,categoryid=?,price=?,pdescription=? where pid=?",p.getPname(),p.getCategoryid(),p.getPrice(),p.getPdescription(),p.getPid());
    }

    @Override
    public List<Product> findProduct() throws SQLException {
        logger.info("进入持久侧-查找商品");
        return qr.query("select * from product", new BeanListHandler<Product>(Product.class));
    }

    @Override
    public List<Product> findProductByCategory(Integer categoryid) throws SQLException {
        logger.info("进入持久侧-查找同一类别的所有商品");
        return qr.query("select * from product where categoryid = ?", new BeanListHandler<Product>(Product.class),categoryid);
    }

    @Override
    public Product findProductById(Integer pid) throws Exception {
        logger.info("进入持久侧-根据pid查找商品");
        return qr.query("select * from product where pid = ?", new BeanHandler<Product>(Product.class),pid);
    }
}
