package org.javemos.ssmcrud.controller;

import org.apache.log4j.Logger;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 */
@Controller
public class CustomerController {
    private static Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        logger.info("进入CustomerController中的gutCustomerById方法");
        Customer customer = customerService.getCustomerById(14L);
        System.out.println(customer);
        return customer;
    }

}
