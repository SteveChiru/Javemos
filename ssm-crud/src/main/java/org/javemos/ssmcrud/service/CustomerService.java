package org.javemos.ssmcrud.service;

import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.utils.PageResult;
import org.javemos.ssmcrud.utils.QueryVo;

/**
 * @Description:
 */
public interface CustomerService {
    public PageResult getCustomerList(QueryVo queryVo);
    public Customer getCustomerById(Long id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Long id);
}
