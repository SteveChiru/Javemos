package org.javemos.pm.service;

import org.javemos.pm.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public interface ProductService {
    public void addProduct(Product p) throws SQLException;
    public void delProduct(Integer pid) throws SQLException;
    public void delMultiProduct(String pids) throws Exception;
    public void updateProduct(Product p) throws SQLException;
    public List<Product> findProduct() throws SQLException;
    public List<Product> findProductByCategory(Integer categoryid) throws SQLException;
    public Product findProductById(Integer pid) throws Exception;
}
