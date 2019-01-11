package org.javemos.pm.service.impl;

import org.javemos.pm.dao.ProductDao;
import org.javemos.pm.dao.impl.ProductDaoImpl;
import org.javemos.pm.domain.Product;
import org.javemos.pm.service.ProductService;

import java.sql.SQLException;

/**
 * @Description:
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(Product p) throws SQLException {
        ProductDao dao = new ProductDaoImpl();
        dao.addProduct(p);
    }
}
