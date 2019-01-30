package org.javemos.ssmcrud.dao;

import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.utils.QueryVo;

import java.util.List;

/**
 * @Description:
 */
public interface CustomerDao {
   public List<Customer> getCustomerList(QueryVo queryVo);
   public Customer getCustomerById(Long id);
   public void updateCustomer(Customer customer);
   public void deleteCustomer(Long id);
}
