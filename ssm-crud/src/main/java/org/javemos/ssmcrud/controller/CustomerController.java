package org.javemos.ssmcrud.controller;

import org.apache.log4j.Logger;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();

        Customer cust1 = new Customer();
        cust1.setCust_name("小明");
        cust1.setCust_id(1L);

        Customer cust2 = new Customer();
        cust2.setCust_name("小刚");
        cust2.setCust_id(2L);

        customerList.add(cust1);
        customerList.add(cust2);

        return customerList;
    }

    @RequestMapping("/customer/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        logger.info("进入CustomerController中的gutCustomerById方法");
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

}
