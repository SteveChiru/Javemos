package org.javemos.ssmcrud.service;

import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.pojo.QueryVo;

import java.util.List;

/**
 * @Description:
 */
public interface CustomerService {
    public List<Customer> getCustomerList(QueryVo queryVo);
    public Integer getCustomerListCount(QueryVo queryVo);
    public Customer getCustomerById(Long id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Long id);
}
