package org.javemos.ssmcrud.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.javemos.ssmcrud.pojo.BaseDict;
import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.pojo.QueryVo;
import org.javemos.ssmcrud.service.BaseDictService;
import org.javemos.ssmcrud.service.CustomerService;
import org.javemos.ssmcrud.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Page<Customer> showCustomerList(){
        Page<Customer> page = new Page<>();

        return page;
    }

    @RequestMapping("/customer/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        logger.info("进入CustomerController中的gutCustomerById方法");
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

}
