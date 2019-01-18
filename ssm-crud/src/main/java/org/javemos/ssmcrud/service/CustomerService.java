package org.javemos.ssmcrud.service;

import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.pojo.QueryVo;
import org.javemos.ssmcrud.utils.Page;

/**
 * @Description:
 */
public interface CustomerService {
   public Page<Customer> getCustomerList(QueryVo queryVo);
   public Customer getCustomerById(Long id);
   public void updateCustomer(Customer customer);
   public void deleteCustomer(Long id);
}
