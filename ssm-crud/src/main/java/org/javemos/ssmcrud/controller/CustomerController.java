package org.javemos.ssmcrud.controller;

import com.github.pagehelper.Page;
import org.apache.log4j.Logger;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.service.CustomerService;
import org.javemos.ssmcrud.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 */
@Controller
public class CustomerController {
    private static Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/list")
    @ResponseBody
    public PageResult showCustomerList(int page,int rows){
    	logger.info("进入CustomerController中的showCustomerList方法");
        return customerService.getCustomerList(page,rows);
    }

    @RequestMapping("/customer/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        logger.info("进入CustomerController中的getCustomerById方法");
		Customer customer = customerService.getCustomerById(id);
		return customer;
    }

    @RequestMapping(value = "/customer/update",method = RequestMethod.POST)
	@ResponseBody
	public String updateCustomer(Customer customer){
    	logger.info("进入CustomerController中的updateController方法");
    	customerService.updateCustomer(customer);
    	return "OK";
	}
}
