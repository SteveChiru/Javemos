package org.javemos.ssmcrud.service;

import org.javemos.ssmcrud.pojo.BaseDict;

import java.util.List;

/**
 * @Description:
 */
public interface BaseDictService {
    List<BaseDict> getDictListByTypeCode(String typeCode);
}
