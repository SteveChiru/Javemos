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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 */
@Controller
public class CustomerController {
    private static Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;
    @Value("${customer.source.code}")
    private String custSourceCode;
    @Value("${customer.industory.code}")
    private String custIndustoryCode;
    @Value("${customer.level.code}")
    private String custLevelCode;

    @RequestMapping("/customer/list")
    public String showCustomerList(QueryVo queryVo, Model model) throws Exception {
        logger.info("进入CustomerController中的showCustomerList方法");
        //乱码处理
        if (StringUtils.isNotBlank(queryVo.getCustName())){
            queryVo.setCustName(new String(queryVo.getCustName().getBytes("iso8859-1"), "utf-8"));
        }
        //初始化客户来源
        List<BaseDict> sourceList = baseDictService.getDictListByTypeCode(custSourceCode);
        //所属行业
        List<BaseDict> industoryList = baseDictService.getDictListByTypeCode(custIndustoryCode);
        //客户级别
        List<BaseDict> levelList = baseDictService.getDictListByTypeCode(custLevelCode);
        //把字典信息传递给页面
        model.addAttribute("fromType", sourceList);
        model.addAttribute("industryType", industoryList);
        model.addAttribute("levelType", levelList);
        //根据查询条件查询客户列表
        Page<Customer> page = customerService.getCustomerList(queryVo);
        //把客户列表传递给页面
        model.addAttribute("page", page);
        //参数回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustory());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        return "customer";
    }

    @RequestMapping("/customer/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        logger.info("进入CustomerController中的gutCustomerById方法");
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping(value="/customer/update", method=RequestMethod.POST)
    @ResponseBody
    public String updateCustomer(Customer customer) {
        logger.info("进入CustomerController中的updateController方法");
        customerService.updateCustomer(customer);
        return "OK";
    }

    @RequestMapping("/customer/delete")
    @ResponseBody
    public String deleteCustomer(Long id) {
        logger.info("进入CustomerController中的deleteCustomer方法");
        customerService.deleteCustomer(id);
        return "OK";
    }
}
