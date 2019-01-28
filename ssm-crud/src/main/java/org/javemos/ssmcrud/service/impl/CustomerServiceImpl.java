package org.javemos.ssmcrud.service.impl;

import org.apache.log4j.Logger;
import org.javemos.ssmcrud.dao.CustomerDao;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.pojo.QueryVo;
import org.javemos.ssmcrud.service.CustomerService;
import org.javemos.ssmcrud.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Page<Customer> getCustomerList(QueryVo queryVo) {
        return null;
    }

    @Override
    public Integer getCustomerListCount(QueryVo queryVo) {
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        logger.info("进入服务层-CustomerServiceImpl-getCustomerById方法");
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
