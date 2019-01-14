package org.javemos.pm.dao;

import org.javemos.pm.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public interface ProductDao  {
    public void addProduct(Product p) throws SQLException;
    public void delProduct(Integer pid) throws SQLException;
    public void updateProduct(Product p) throws SQLException;
    public List<Product> findProduct() throws SQLException;
    public List<Product> findProductByCategory(Integer categoryid) throws SQLException;
    public Product findProductById(Integer pid) throws Exception;
}
