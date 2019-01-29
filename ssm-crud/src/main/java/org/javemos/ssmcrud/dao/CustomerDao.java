package org.javemos.ssmcrud.dao;

import org.javemos.ssmcrud.pojo.Customer;

import java.util.List;

/**
 * @Description:
 */
public interface CustomerDao {
   public List<Customer> getCustomerList();
   public Customer getCustomerById(Long id);
   public void updateCustomer(Customer customer);
}
