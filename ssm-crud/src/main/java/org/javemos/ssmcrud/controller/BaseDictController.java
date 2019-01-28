package org.javemos.ssmcrud.controller;

import org.apache.log4j.Logger;
import org.javemos.ssmcrud.pojo.BaseDict;
import org.javemos.ssmcrud.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@Controller
public class BaseDictController {
    private static Logger logger = Logger.getLogger(BaseDictController.class);

    @Autowired
    private BaseDictService baseDictService;
    @Value("${customer.source.code}")
    private String custSourceCode;
    @Value("${customer.industory.code}")
    private String custIndustoryCode;
    @Value("${customer.level.code}")
    private String custLevelCode;

    @RequestMapping("/dict/load")
    @ResponseBody
    public Map<String, List<BaseDict>> loadDataFromDict(){
        Map<String,List<BaseDict>> map = new HashMap<>();
        //获取用户来源字典记录
        List<BaseDict> custSourceDictList = baseDictService.getDictListByTypeCode(custSourceCode);
        //获取用户行业字典记录
        List<BaseDict> custIndustryDictList = baseDictService.getDictListByTypeCode(custIndustoryCode);
        //获取用户等级字典记录
        List<BaseDict> custLevelDictList = baseDictService.getDictListByTypeCode(custLevelCode);

        map.put("custSourceInit",custSourceDictList);
        map.put("custIndustryInit",custIndustryDictList);
        map.put("custLevelInit",custLevelDictList);

        return map;
    }
}
