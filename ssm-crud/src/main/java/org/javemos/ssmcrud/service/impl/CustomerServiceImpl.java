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
        logger.info("进入服务层-CustomerServiceImpl-getCustomerList方法");
        //计算分页开始记录
        if (queryVo.getPage() != null){
            queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());
        }
        List<Customer> customerList = customerDao.getCustomerList(queryVo);
        //创建一个Page对象
        Page<Customer> page = new Page<>();
        page.setRows(customerList);
        //查询总记录数
        Integer count = customerDao.getCustomerListCount(queryVo);
        page.setTotal(count);
        page.setSize(queryVo.getSize());
        page.setPage(queryVo.getPage());
        //返回结果
        return page;
    }

    @Override
    public Customer getCustomerById(Long id) {
        logger.info("进入服务层-CustomerServiceImpl-getCustomerById方法");
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        logger.info("进入服务层-CustomerServiceImpl-updateCustomer方法");
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        logger.info("进入服务层-CustomerServiceImpl-deleteCustomer方法");
        customerDao.deleteCustomer(id);
    }
}
