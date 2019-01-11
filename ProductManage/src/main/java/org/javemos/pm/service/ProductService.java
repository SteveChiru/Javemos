package org.javemos.pm.service;

import org.javemos.pm.domain.Product;

import java.sql.SQLException;

/**
 * @Description:
 */
public interface ProductService {
    public void addProduct(Product p) throws SQLException;
}
