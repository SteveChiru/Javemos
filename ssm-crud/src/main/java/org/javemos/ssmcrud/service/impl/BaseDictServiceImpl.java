package org.javemos.ssmcrud.service.impl;

import org.apache.log4j.Logger;
import org.javemos.ssmcrud.dao.BaseDictDao;
import org.javemos.ssmcrud.pojo.BaseDict;
import org.javemos.ssmcrud.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
    private static Logger logger = Logger.getLogger(BaseDictServiceImpl.class);

    @Autowired
    private BaseDictDao baseDictDao;
    @Override
    public List<BaseDict> getDictListByTypeCode(String typeCode) {
        logger.info("进入服务层-BaseDictServiceImpl-getDictListByTypeCode方法");
        List<BaseDict> list = baseDictDao.getDictListByTypeCode(typeCode);
        return list;
    }
}
