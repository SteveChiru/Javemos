package org.javemos.pm.dao;

import org.javemos.pm.domain.Product;

import java.sql.SQLException;

/**
 * @Description:
 */
public interface ProductDao  {
    public void addProduct(Product p) throws SQLException;
}
