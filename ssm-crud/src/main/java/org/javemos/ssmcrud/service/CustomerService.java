package org.javemos.ssmcrud.service;

import com.github.pagehelper.Page;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.pojo.QueryVo;
import org.javemos.ssmcrud.utils.PageResult;

/**
 * @Description:
 */
public interface CustomerService {
    public PageResult getCustomerList(int pageNum,int pageSize);
    public Customer getCustomerById(Long id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Long id);
}
