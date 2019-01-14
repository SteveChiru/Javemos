package org.javemos.pm.service.impl;

import org.apache.log4j.Logger;
import org.javemos.pm.dao.ProductDao;
import org.javemos.pm.dao.impl.ProductDaoImpl;
import org.javemos.pm.domain.Product;
import org.javemos.pm.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public class ProductServiceImpl implements ProductService {
    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
    private static ProductDao dao = new ProductDaoImpl();

    @Override
    public void addProduct(Product p) throws SQLException {
        logger.info("进入服务层-添加商品");
        dao.addProduct(p);
    }

    @Override
    public void delProduct(Integer pid) throws SQLException {
        logger.info("进入服务层-删除商品");
        dao.delProduct(pid);
    }

    @Override
    public void delMultiProduct(String pids) throws Exception {
        logger.info("进入服务层-删除多个商品");
        String[] arr = pids.split(",");
        for (String id : arr){
            Integer pid = new Integer(id);
            dao.delProduct(pid);
        }
    }

    @Override
    public void updateProduct(Product p) throws SQLException {
        logger.info("进入服务层-更新商品");
        dao.updateProduct(p);
    }

    @Override
    public List<Product> findProduct() throws SQLException {
        logger.info("进入服务层-查找所有商品");
        return dao.findProduct();
    }

    @Override
    public List<Product> findProductByCategory(Integer categoryid) throws SQLException {
        logger.info("进入服务层-查找同一类别下的所有商品");
        return dao.findProductByCategory(categoryid);
    }

    @Override
    public Product findProductById(Integer pid) throws Exception {
        logger.info("进入服务层-根据pid查找商品");
        return dao.findProductById(pid);
    }
}
