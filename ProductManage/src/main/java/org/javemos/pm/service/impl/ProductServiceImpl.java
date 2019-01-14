package org.javemos.pm.service.impl;

import org.apache.log4j.Logger;
import org.javemos.pm.dao.ProductDao;
import org.javemos.pm.dao.impl.ProductDaoImpl;
import org.javemos.pm.domain.Product;
import org.javemos.pm.service.ProductService;

import java.sql.SQLException;

/**
 * @Description:
 */
public class ProductServiceImpl implements ProductService {
    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @Override
    public void addProduct(Product p) throws SQLException {
        logger.info("进入服务层-添加商品");
        ProductDao dao = new ProductDaoImpl();
        dao.addProduct(p);
    }
}
