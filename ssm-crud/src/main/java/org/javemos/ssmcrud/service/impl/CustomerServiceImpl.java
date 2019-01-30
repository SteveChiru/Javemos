package org.javemos.ssmcrud.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.javemos.ssmcrud.dao.CustomerDao;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.service.CustomerService;
import org.javemos.ssmcrud.utils.PageResult;
import org.javemos.ssmcrud.utils.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDao customerDao;

	@Override
	public PageResult getCustomerList(QueryVo queryVo) {
		logger.info("进入服务层-CustomerServiceImpl-getCustomerList方法");
		PageHelper.startPage(queryVo.getPage(),queryVo.getRows());
		Page<Customer> page = (Page<Customer>) customerDao.getCustomerList(queryVo);
		return new PageResult(page.getTotal(),page.getPages(),page.getResult());
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
