package org.javemos.pm.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.javemos.pm.dao.ProductDao;
import org.javemos.pm.domain.Product;
import org.javemos.pm.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @Description:
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public void addProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update("insert into product (pname,price,path,pdescription,categoryid) values (?,?,?,?,?)",p.getPname(),p.getPrice(),p.getPath(),p.getPdescription(),p.getCategoryid());
    }
}
