package org.javemos.pm.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.log4j.Logger;
import org.javemos.pm.dao.ProductDao;
import org.javemos.pm.domain.Product;
import org.javemos.pm.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @Description:
 */
public class ProductDaoImpl implements ProductDao {
    private static Logger logger = Logger.getLogger(ProductDaoImpl.class);

    @Override
    public void addProduct(Product p) throws SQLException {
        logger.info("进入持久层-添加商品");
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update("insert into product (pname,price,path,pdescription,categoryid) values (?,?,?,?,?)",p.getPname(),p.getPrice(),p.getPath(),p.getPdescription(),p.getCategoryid());
    }
}
